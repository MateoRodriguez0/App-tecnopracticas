package com.proyecto.practicas.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.practicas.models.Postulacion;
import com.proyecto.practicas.repositories.PostulacionRepository;
import com.proyecto.practicas.services.PostulacionServices;
import com.proyecto.practicas.services.UserService;

@Service
public class PostulacionServiceImpl implements PostulacionServices {

	@Override
	public List<Postulacion> getPostulacionesByOferta(Long id) {
		
		return null;
	}

	@Override
	public List<Postulacion> getPostulacionesByEstudiante(String email) {
		
		
		List<Postulacion> postulaciones=userService.getUsuarioByEmail(email).getPostulaciones();
		
		return postulaciones;
	}
	
	@Override
	public List<Postulacion> getAllPostulaciones() {
		
		return postulacionRepository.findAll();
	}
	
	

	
	@Autowired
	private UserService userService;

	@Autowired
	private PostulacionRepository postulacionRepository;
	
	
}
