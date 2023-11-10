package com.proyecto.practicas.services;

import java.util.List;

import com.proyecto.practicas.models.Rol;

public interface RolServices {
	
	Rol getRolById(Long id);
	
	List<Rol> getRoles();
}
