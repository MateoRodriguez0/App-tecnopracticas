package com.proyecto.practicas.services.implementations;

import com.proyecto.practicas.models.Carrera;
import com.proyecto.practicas.models.OfertaPractica;

import com.proyecto.practicas.repositories.OfertaRepository;
import com.proyecto.practicas.services.CarreraServices;
import com.proyecto.practicas.services.OfertaServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfertaServicesImpl implements OfertaServices {

	@Override
	public OfertaPractica getOfertaById(Long id) {
		
		OfertaPractica oferta = ofertaRepository
				.findById(id)
				.orElse(null);
		
		return oferta;
	}

	@Override
	public List<OfertaPractica> getOfertas() {
		
		return ofertaRepository.findAll();
	}

	@Override
	public List<OfertaPractica> getOfertasPorCarrera(Long id) {
		
		Carrera carrera = carreraServices
				.getCarreraById(id);
		
		return carrera.getOfertaPracticas();
	}
	
	@Autowired
	private CarreraServices carreraServices;
	
	@Autowired
	private OfertaRepository ofertaRepository;
}
	