package com.proyecto.practicas.services;

import org.springframework.security.core.Authentication;

import com.proyecto.practicas.models.OfertaPractica;
import com.proyecto.practicas.models.Usuario;

public interface AdminServices {
	
	void RegistrarAdmin(Usuario usuario);
	
	void publicarOferta(OfertaPractica ofertaPractica,Authentication authentication);
	
	void actualizarOferta(OfertaPractica ofertaPractica);
	
	void eliminarOferta(Long id);
	
}
