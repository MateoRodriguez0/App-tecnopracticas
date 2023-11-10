package com.proyecto.practicas.services.implementations;

import com.proyecto.practicas.models.Carrera;
import com.proyecto.practicas.repositories.CarreraRepository;
import com.proyecto.practicas.services.CarreraServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraServicesImpl implements CarreraServices {


    @Autowired
    private CarreraRepository carreraRepository;

	@Override
	public void guardarCarrera(Carrera carrera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Carrera getCarreraById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carrera> getCarreras() {
		// TODO Auto-generated method stub
		return null;
	}
}
