package com.proyecto.practicas.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyecto.practicas.models.OfertaPractica;
import com.proyecto.practicas.services.CarreraServices;
import com.proyecto.practicas.services.OfertaServices;
import com.proyecto.practicas.services.UserService;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class OfertasController {
	
	
	private final String urlOfertas="ofertas/Ofertas";

	
	@GetMapping(value = "/carrera/ofertas/{id}")
	public String getOfertasPorCarrera(@PathVariable(name = "id")Long id, Authentication authentication, Model model) {
		
		List<OfertaPractica> ofertas=ofertaServices.getOfertasPorCarrera(id);
		
		model.addAttribute("ofertas", ofertas);
		model.addAttribute("username",userService.getnameByEmail(authentication.getName()));
		model.addAttribute("carrera", carreraServices.getCarreraById(id));
		
		return urlOfertas;
	}
	
	
	
	
	
	
	
	@Autowired
	private OfertaServices ofertaServices;
	
	@Autowired
	private CarreraServices carreraServices;
	
	@Autowired
	private UserService userService;
	
	
}
