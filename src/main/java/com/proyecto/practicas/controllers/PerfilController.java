package com.proyecto.practicas.controllers;


import org.springframework.web.bind.annotation.GetMapping;


public class PerfilController {

	
	private final String urlPerfil="";
	
	@GetMapping(value = "/perfil")
	public String getVerPerfilUser() {
		return urlPerfil;
	}
		
}
