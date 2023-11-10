package com.proyecto.practicas.services;

import java.util.List;

import com.proyecto.practicas.models.Postulacion;

public interface PostulacionServices {
	
	List<Postulacion> getPostulacionesByOferta(Long id);
	
	List<Postulacion> getPostulacionesByEstudiante(Long id);
	
	
}
