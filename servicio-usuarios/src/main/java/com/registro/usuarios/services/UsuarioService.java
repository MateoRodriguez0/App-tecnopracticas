package com.registro.usuarios.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	public Usuario getInfo(UUID id) {
		Usuario us=repository.findById(id).orElse(null);
		us.setPassword(null);
		us.setRoles(null);
		
		String carrera= repository.buscarCarreraByUsuario(id);
		us.setCarrera(carrera);
		return us;
		
	}
	
	@Autowired
	private UsuarioRepository repository;
}
