package com.serviciopostulacion.services;

import com.serviciopostulacion.clients.MensajeriaClient;
import com.serviciopostulacion.model.Carreras;
import com.serviciopostulacion.model.Empresa;
import com.serviciopostulacion.model.EstadoPostulacion;
import com.serviciopostulacion.model.Oferta;
import com.serviciopostulacion.model.Postulacion;
import com.serviciopostulacion.model.PostulacionEmail;
import com.serviciopostulacion.model.Usuario;
import com.serviciopostulacion.repositories.OfertasRepository;
import com.serviciopostulacion.repositories.PostulacionRepository;
import com.serviciopostulacion.repositories.UsuarioRepository;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

@Service
public class PostulacionService {
	@Autowired
	private PostulacionRepository postulacionRepository;

	@Autowired
	private MensajeriaClient client;

	@Autowired
	private OfertasRepository ofertasRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Postulacion> listarPostulaciones() {
		return postulacionRepository.findAll();
	}

	public Postulacion obtenerPostulacionPorId(UUID id) {
		return postulacionRepository.findById(id).orElse(null);
	}

	public List<Postulacion> obtenerPostulacionesPorEmpresa(UUID id) {
		Empresa empresa = new Empresa();
		empresa.setId(id);

		return ofertasRepository.findByEmpresa(empresa).stream().map(o -> o.getPostulaciones()).flatMap(t -> t.stream())
				.toList();
	}

	public List<Postulacion> obtenerPostulacionesPorCarrera(UUID id) {
		return ofertasRepository.findByCarrera(new Carreras(id))
				.stream().map(o -> o.getPostulaciones()).flatMap(p -> p.stream())
				.toList();
	}


	public String crearPostulacion(UUID id, Oferta oferta) {
		Postulacion postulacion = new Postulacion();
		postulacion.setOferta(oferta);
		postulacion.setUsuario(Usuario.builder().id(id).build());
		postulacion.setEstadoPostulacion(EstadoPostulacion.recibida);
		postulacion.setFecha_postulacion(Timestamp.from(Instant.now()));
		System.out.println(id+" "+oferta);

		try (var scope = new StructuredTaskScope<>()) {
			Subtask<UUID> ofertaCarrera = scope.fork(() -> 
				ofertasRepository.getIdCarreraByOferta(postulacion.getOferta().getId()));
			Subtask<UUID> usuarioCarrera = scope.fork(() -> 
				usuarioRepository.getIdCarreraByUsuario(id));
			scope.join();
			System.out.println(postulacion.getUsuario().getCarrera()+" "+ofertaCarrera.get());
			if (usuarioCarrera.get().equals(ofertaCarrera.get())) {
				postulacionRepository.save(postulacion);
				PostulacionEmail email = getPostulacionEmail(postulacion, id);
				client.PostulacionCreada(email);
			} else {
				return "CarreraUsuarioNoCoincide";
			}

		} catch (feign.RetryableException e) {
			e.printStackTrace();
			if (e.getCause().getClass() == java.net.SocketTimeoutException.class) {
				return "postulacionCreada";
			}
			;
			return "postulacionCreadaEmailNoEnviado";
		} catch (InterruptedException e) {
		} catch (DataIntegrityViolationException e) {
			return "YaEstabaPostulado";
		}
		return "postulacionNOCreada";
	}

	public Postulacion actualizarPostulacion(Postulacion postulacion) {
		return postulacionRepository.save(postulacion);
	}

	public void eliminarPostulacion(UUID id) {
		postulacionRepository.deleteById(id);
	}

	public String aprobarPostulacion(UUID id) {
		Postulacion post = postulacionRepository.findById(id).orElse(null);
		if (post == null) {
			return "NoSePudoAprobar";
		}
		if (post.getEstadoPostulacion() == EstadoPostulacion.En_revisión) {
			post.setFecha_aprobada(Timestamp.from(Instant.now()));
			post.setEstadoPostulacion(EstadoPostulacion.Seleccionada);
			try{
				PostulacionEmail email = getPostulacionEmail(post);
				postulacionRepository.save(post);
				if(email==null) {
					return "postulacionAprobadaEmailNoEnviado";
				}
				client.postulacionAprobada(email);
			} catch (feign.RetryableException e) {
				if (e.getCause().getClass() == java.net.SocketTimeoutException.class) {
					return "postulacionAprobada";
				}
				return "postulacionAprobadaEmailNoEnviado";
			} 
			return "NoSePudoAprobar";

		} else {
			return "NoSePudoAprobar";
		}
	}

	public String rechazarPostulacion(UUID id) {
		Postulacion post = postulacionRepository.findById(id).orElse(null);
		if (post == null) {
			return "NoSePudoDescartar";
		}
		if (post.getEstadoPostulacion() == EstadoPostulacion.En_revisión) {
			post.setFecha_descartada(Timestamp.from(Instant.now()));
			post.setEstadoPostulacion(EstadoPostulacion.No_seleccionada);
			try{
				PostulacionEmail email = getPostulacionEmail(post);
				postulacionRepository.save(post);
				if(email==null) {
					return "postulacionDescartadaEmailNoEnviado";
				}
				client.postulacionRechazada(email);
			} catch (feign.RetryableException e) {
				if (e.getCause().getClass() == java.net.SocketTimeoutException.class) {
					return "postulacionDescartada";
				}
				return "postulacionDescartadaEmailNoEnviado";
			} 
			return "NoSePudoDescartar";

		} else {
			return "NoSePudoDescartar";
		}

	}

	public String RevisarPostulacion(UUID id) {
		Postulacion post = postulacionRepository.findById(id).orElse(null);
		if (post == null) {
			return "NoSePudoRevisar";
		}
		if (post.getEstadoPostulacion() == EstadoPostulacion.recibida) {
			post.setFecha_revision(Timestamp.from(Instant.now()));
			post.setEstadoPostulacion(EstadoPostulacion.En_revisión);
			try{
				PostulacionEmail email = getPostulacionEmail(post);
				postulacionRepository.save(post);
				if(email==null) {
					return "postulacionEnRevisionEmailNoEnviado";
				}
				client.PostulacionEnRevision(email);
			} catch (feign.RetryableException e) {
				if (e.getCause().getClass() == java.net.SocketTimeoutException.class) {
					return "postulacionEnRevision";
				}
				return "postulacionEnRevisionEmailNoEnviado";
			} 
			return "NoSePudoRevisar";

		} else {
			return "NoSePudoRevisar";
		}
	}
	// Listar postulaciones de un usurio
	public List<Postulacion> getPostulacionesById(UUID Id) {
		Usuario usuario= new Usuario(Id);
		return postulacionRepository.findByUsuario(usuario);
	}
	
	public PostulacionEmail getPostulacionEmail(Postulacion post,UUID id) {
		try (var scope = new StructuredTaskScope<>()) {
			Subtask<String> emailUsuario = scope.fork(() -> 
				usuarioRepository.getemailById(id));
			Subtask<String> empresa = scope.fork(() -> 
				ofertasRepository.getNombreEmpresaByOferta(post.getOferta().getId()));
			Subtask<String> puesto = scope.fork(() -> 
				ofertasRepository.getNombrePuestoByOferta(post.getOferta().getId()));
			scope.join();
			PostulacionEmail email = new PostulacionEmail(
					emailUsuario.get(), puesto.get(), empresa.get());
		
			return email;
		}  catch (InterruptedException e) {
		}
		return null;
	}
	
	public PostulacionEmail getPostulacionEmail(Postulacion post) {
		try (var scope = new StructuredTaskScope<>()) {
			
			Subtask<String> empresa = scope.fork(() -> 
				ofertasRepository.getNombreEmpresaByOferta(post.getOferta().getId()));
			Subtask<String> puesto = scope.fork(() -> 
				ofertasRepository.getNombrePuestoByOferta(post.getOferta().getId()));
			scope.join();
			PostulacionEmail email = new PostulacionEmail(
					post.getUsuario().getCorreo(), puesto.get(), empresa.get());
		
			return email;
		}  catch (InterruptedException e) {
		}
		return null;
	}

}
