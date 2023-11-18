package com.proyecto.practicas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.practicas.models.OfertaPractica;
import com.proyecto.practicas.services.OfertaServices;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class OfertasController {
	
	
	private final String urlOfertas="";
	
	@GetMapping(value = "/carrea/ofertas/{id}")
	public String getOfertasPorCarrera(@PathVariable(name = "id")Long id,Model model) {
		
		List<OfertaPractica> ofertas=ofertaServices.getOfertasPorCarrera(id);
		
		model.addAttribute("ofertas", ofertas);
		System.out.println(id);
		
		return urlOfertas;
	}
	
	@Autowired
	private OfertaServices ofertaServices;
}
