package com.registro.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.registro.usuarios.services.AuthUsuarioSerivice;

@RestController
public class UsuariosAuthController {
	 
	@Autowired
	private AuthUsuarioSerivice authUsuarioSerivice; 

	@GetMapping(value="/buscar")
	public ResponseEntity<?> verificarUsuario(@RequestParam String email) {
	    	return ResponseEntity.ok(authUsuarioSerivice.getByCorreo(email));
	    }
	 
	 
}
