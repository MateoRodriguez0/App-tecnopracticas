package com.proyecto.practicas.services;

import com.proyecto.practicas.models.Postulacion;
import com.proyecto.practicas.models.Usuario;

public interface EstudianteServices {
	
	void RegistrarAdmin(Usuario usuario);
	
	void guardarPostulacion(Postulacion postulacion);
	
	void eliminarPostulacion(Long id);
	
}
