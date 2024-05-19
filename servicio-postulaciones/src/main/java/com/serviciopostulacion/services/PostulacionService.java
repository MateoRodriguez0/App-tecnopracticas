package com.serviciopostulacion.services;

import com.serviciopostulacion.clients.MensajeriaClient;
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

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

@Service
public class PostulacionService {
	@Autowired
    private  PostulacionRepository postulacionRepository;
    
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

    public String crearPostulacion(UUID id, Oferta oferta) {
    	Postulacion postulacion= new Postulacion();
    	postulacion.setOferta(oferta);
    	postulacion.setUsuario(Usuario.builder().id(id).build());
    	postulacion.setEstadoPostulacion(EstadoPostulacion.recibida);
    	postulacion.setFecha_postulacion(Timestamp.from(Instant.now()));
  
    	try (var scope = new StructuredTaskScope<>()) {
    		Subtask<UUID> ofertaCarrera=scope.fork(() ->
    			ofertasRepository.getIdCarreraByOferta(postulacion.getOferta().getId()));
    		Subtask<UUID> usuarioCarrera=scope.fork(() ->
    			usuarioRepository.getIdCarreraByUsuario(id));
    		scope.join();
    		
    		if(usuarioCarrera.get().equals(ofertaCarrera.get())) {
    			postulacionRepository.save(postulacion);
    			Subtask<String> emailUsuario=scope.fork(() ->
    							usuarioRepository.getemailById(id));
    			Subtask<String> empresa=scope.fork(() ->
    				ofertasRepository.getNombreEmpresaByOferta(postulacion.getOferta().getId()));
    			Subtask<String> puesto=scope.fork(() ->
    				ofertasRepository.getNombrePuestoByOferta(postulacion.getOferta().getId()));
        		scope.join();
        		PostulacionEmail email= new PostulacionEmail(
        				emailUsuario.get(), puesto.get(), empresa.get());
        		client.PostulacionCreada(email);
    		}
    		else {
    			return "CarreraUsuarioNoCoincide";
    		}
    		
  		}catch (feign.RetryableException e) {
  			if(e.getCause().getClass()==java.net.SocketTimeoutException.class) {
  				return "postulacionCreada";
   			};
   			return "postulacionCreadaEmailNoEnviado";
		} catch (InterruptedException e) {}
    	return "postulacionNOCreada";
    }

    public Postulacion actualizarPostulacion(Postulacion postulacion) {
        return postulacionRepository.save(postulacion);
    }

    public void eliminarPostulacion(UUID id) {
        postulacionRepository.deleteById(id);
    }

    public Postulacion aprobarPostulacion(UUID id) {
        Optional<Postulacion> postulacionOptional = postulacionRepository.findById(id);
        if (postulacionOptional.isPresent()) {
            Postulacion postulacion = postulacionOptional.get();
            postulacion.setEstadoPostulacion(EstadoPostulacion.Seleccionada);
            return postulacionRepository.save(postulacion);
        }
        return null;
    }

    public Postulacion rechazarPostulacion(UUID id) {
        Optional<Postulacion> postulacionOptional = postulacionRepository.findById(id);
        if (postulacionOptional.isPresent()) {
            Postulacion postulacion = postulacionOptional.get();
            postulacion.setEstadoPostulacion(EstadoPostulacion.No_seleccionada);
            return postulacionRepository.save(postulacion);
        }
        return null;
    }

    public Postulacion cambiarEstadoPostulacion(UUID id, EstadoPostulacion nuevoEstado) {
        Optional<Postulacion> postulacionOptional = postulacionRepository.findById(id);
        if (postulacionOptional.isPresent()) {
            Postulacion postulacion = postulacionOptional.get();
            postulacion.setEstadoPostulacion(nuevoEstado);
            return postulacionRepository.save(postulacion);
        }
        return null;
    }

    //Listar postulaciones de un usurio
    public Optional<Postulacion> getPostulacionesById(UUID Id) {
        return postulacionRepository.findById(Id);
    }


}

