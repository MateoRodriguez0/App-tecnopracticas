package com.registro.usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.models.UsuarioAuth;
import com.registro.usuarios.repositories.UsuarioRepository;

@Service
public class AuthUsuarioSerivice {
	@Autowired
    private UsuarioRepository usuarioRepository;

	public UsuarioAuth getByCorreo(String correo) {
		return new UsuarioAuth(usuarioRepository.findByCorreo(correo));
	}
}
