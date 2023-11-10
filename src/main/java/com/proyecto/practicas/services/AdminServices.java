package com.proyecto.practicas.services;

import com.proyecto.practicas.models.OfertaPractica;
import com.proyecto.practicas.models.Usuario;

public interface AdminServices {
	
	void RegistrarAdmin(Usuario usuario);
	
	void publicarOferta(OfertaPractica ofertaPractica);
	
	void actualizarOferta(OfertaPractica ofertaPractica);
	
	void eliminarOferta(Long id);
	
}
