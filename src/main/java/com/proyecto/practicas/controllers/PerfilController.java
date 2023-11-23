package com.proyecto.practicas.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.practicas.models.Postulacion;
import com.proyecto.practicas.services.PostulacionServices;
import com.proyecto.practicas.services.UserService;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class PerfilController {

	
	private final String urlPerfilestudiante="estudiante/Mi perfil";
	private final String urlPerfilAdmin="administrador/Administrador";
	
	@GetMapping(value = "/myaccount")
	public String getVerPerfilUser(Authentication authentication,Model model) {
		
		String authority= authentication.getAuthorities().stream().findFirst().get().getAuthority();
		
		model.addAttribute("nombre_usuario", userService.getnameByEmail(authentication.getName()));
		
		if(authority.equalsIgnoreCase("ESTUDIANTE")) {
			
			List<Postulacion> postulaciones= postulacionServices
					.getPostulacionesByEstudiante(authentication.getName());
			
			model.addAttribute("mispostulaciones", postulaciones);
			
			return urlPerfilestudiante;
					
		}
		
		if(authority.equalsIgnoreCase("ADMINISTRADOR")) {
			
			model.addAttribute("postulaciones", postulacionServices.getAllPostulaciones());
			
			return urlPerfilAdmin;
					
		}
		
		return urlPerfilAdmin;
	}
	
	@Autowired
	private PostulacionServices postulacionServices;
	
	@Autowired
	private UserService userService;
}
