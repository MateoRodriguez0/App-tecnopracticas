package com.proyecto.practicas.services.implementations;

import com.proyecto.practicas.models.Empresa;
import com.proyecto.practicas.repositories.EmpresaRepository;
import com.proyecto.practicas.services.EmpresaServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServicesImpl implements EmpresaServices {

	@Override
	public void guardarEmpresa(Empresa empresa) {
		
		empresaRepository.save(empresa);
	
	}

	@Override
	public Empresa getEmpresaByid(Long id) {
		
		return empresaRepository
				.findById(id)
				.orElse(null);
	}

	@Override
	public List<Empresa> getEmpresas() {

		return empresaRepository.findAll();
	}
	
	@Autowired
	private EmpresaRepository empresaRepository;
}
