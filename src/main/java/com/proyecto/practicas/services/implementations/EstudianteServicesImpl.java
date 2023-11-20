package com.proyecto.practicas.services.implementations;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.practicas.models.Postulacion;
import com.proyecto.practicas.models.Usuario;
import com.proyecto.practicas.repositories.PostulacionRepository;
import com.proyecto.practicas.services.EstudianteServices;

@Service
public class EstudianteServicesImpl implements EstudianteServices{

	@Override
	public void RegistrarAdmin(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarPostulacion(Postulacion postulacion) {
		
		postulacion.setFecha(new Timestamp(System.currentTimeMillis()));
		
		postulacionRepository.save(postulacion);
	}

	@Override
	public void eliminarPostulacion(Long id) {
		
		postulacionRepository.deleteById(id);
	}
	
	@Autowired
	private PostulacionRepository postulacionRepository;
 }
