package com.proyecto.practicas.services;

import java.util.List;

import com.proyecto.practicas.models.Empresa;

public interface EmpresaServices {
	
	Void guardarEmpresa(Empresa empresa);
	
	
	Empresa getEmpresaByid(Long id);
	
	List<Empresa> getEmpresas();
}
