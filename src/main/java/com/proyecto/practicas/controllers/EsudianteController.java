package com.proyecto.practicas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.practicas.models.Postulacion;
import com.proyecto.practicas.models.Usuario;
import com.proyecto.practicas.services.EstudianteServices;
import com.proyecto.practicas.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/tecnopracticas/estudiante")
public class EsudianteController {

	
	@GetMapping(value = "/postulaciones")
	public String getPostulaciones(Model model){
		
		Usuario estudiante=userService.getUsuarioByEmail("");
		
		List<Postulacion> postulaciones= estudiante.getPostulaciones();
		
		model.addAttribute("postulaciones", postulaciones);
		
		return urlPostulaciones;
	}
	
	
	
	@PostMapping(value = "/postulaciones/nueva")
	public String guardarPostulacion(@Valid Postulacion postulacion,BindingResult bindingResult){
		
		estudianteServices.guardarPostulacion(postulacion);
		
		return urlRedirectpostulaciones;
	}
	
	
	@PostMapping(value = "/postulaciones/eliminar/{id}")
	public String eliminarPostulacion(@PathVariable(name = "id")Long id){
		
		estudianteServices.eliminarPostulacion(id);
	
		return urlRedirectpostulaciones;
	}
	
	
	
	private final String urlPostulaciones="";
	
	private final String urlRedirectpostulaciones="redirect:/tecnopracticas/estudiante/postulaciones";
	
	
	
	@Autowired
	private EstudianteServices estudianteServices;
	
	@Autowired
	private UserService userService;
	
	
}

