package com.proyecto.practicas.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class PerfilController {

	
	private final String urlPerfilestudiante="estudiante/Mi perfil";
	private final String urlPerfilAdmin="administrador/Administrador";
	
	@GetMapping(value = "/myaccount")
	public String getVerPerfilUser() {
		return urlPerfilAdmin;
	}
		
}
