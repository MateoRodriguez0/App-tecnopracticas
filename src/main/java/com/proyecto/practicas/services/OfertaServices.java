package com.proyecto.practicas.services;

import java.util.List;

import com.proyecto.practicas.models.OfertaPractica;

public interface OfertaServices {
	
	OfertaPractica getOfertaById(Long id);

	List<OfertaPractica> getOfertas();
	
	List<OfertaPractica> getOfertasPorCarrera(Long id);
	
}
