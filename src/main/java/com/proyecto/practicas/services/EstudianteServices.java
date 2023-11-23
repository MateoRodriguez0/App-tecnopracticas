package com.proyecto.practicas.services;

import org.springframework.security.core.Authentication;

import com.proyecto.practicas.models.OfertaPractica;

public interface EstudianteServices {
	
	
	void guardarPostulacion(OfertaPractica ofertaPractica,Authentication authentication);
	
	void eliminarPostulacion(Long id);
	
}
