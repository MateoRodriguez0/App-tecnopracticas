package com.proyecto.practicas.services;

import java.util.List;

import com.proyecto.practicas.models.Carrera;

public interface CarreraServices {
	
	void guardarCarrera(Carrera carrera);
	
	Carrera getCarreraById(Long id);

	List<Carrera> getCarreras();
	
	
}
