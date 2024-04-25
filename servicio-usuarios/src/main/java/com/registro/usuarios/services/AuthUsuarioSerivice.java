package com.registro.usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.repositories.UsuarioRepository;

@Service
public class AuthUsuarioSerivice {
	@Autowired
    private UsuarioRepository usuarioRepository;

	public Usuario getByCorreo(String correo) {
		return usuarioRepository.findByCorreo(correo);
		
		
		
	}
}
