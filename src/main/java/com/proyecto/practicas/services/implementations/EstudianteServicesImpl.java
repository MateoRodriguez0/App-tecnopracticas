package com.proyecto.practicas.services.implementations;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.proyecto.practicas.models.OfertaPractica;
import com.proyecto.practicas.models.Postulacion;
import com.proyecto.practicas.models.Usuario;
import com.proyecto.practicas.repositories.PostulacionRepository;
import com.proyecto.practicas.services.EstudianteServices;
import com.proyecto.practicas.services.UserService;

@Service
public class EstudianteServicesImpl implements EstudianteServices{


	@Override
	public void guardarPostulacion(OfertaPractica ofertaPractica,Authentication authentication) {
		
		
		Usuario usuario= userService.getUsuarioByEmail(authentication.getName());
		
		Postulacion postulacion= Postulacion.builder()
		.estudiante(usuario)
		.oferta(ofertaPractica)
		.fecha(new Timestamp(System.currentTimeMillis()))
		.estado("No visto")
		.build();
		
		postulacionRepository.save(postulacion);
	}

	@Override
	public void eliminarPostulacion(Long id) {
		
		postulacionRepository.deleteById(id);
	}
	
	@Autowired
	private PostulacionRepository postulacionRepository;
	
	@Autowired
	private UserService userService;
 }
