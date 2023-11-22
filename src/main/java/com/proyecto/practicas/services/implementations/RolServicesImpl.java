package com.proyecto.practicas.services.implementations;

import com.proyecto.practicas.models.Rol;
import com.proyecto.practicas.repositories.RolRepository;
import com.proyecto.practicas.services.RolServices;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServicesImpl implements RolServices {

    @Autowired
    private RolRepository rolRepository;

	@Override
	public Rol getRolById(Long id) {
		
		return rolRepository
				.findById(id)
				.orElse(null);
	}

	@Override
	public List<Rol> getRoles() {
		
		return rolRepository.findAll()
				.stream()
				.sorted((rol1, rol2) ->rol1.getNombre().compareTo(rol2.getNombre()))
				.collect(Collectors.toList());
	}
}
