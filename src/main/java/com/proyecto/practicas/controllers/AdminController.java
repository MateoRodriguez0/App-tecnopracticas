package com.proyecto.practicas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.practicas.models.Carrera;
import com.proyecto.practicas.models.Empresa;
import com.proyecto.practicas.models.OfertaPractica;
import com.proyecto.practicas.services.AdminServices;
import com.proyecto.practicas.services.CarreraServices;
import com.proyecto.practicas.services.EmpresaServices;
import com.proyecto.practicas.services.OfertaServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class AdminController {

	
	@GetMapping(value = "/ofertas/nueva")
	public String crearnuevaOferta(Model model) {
		
		model.addAttribute("oferta",OfertaPractica.builder().carrera(new Carrera()).empresa(new Empresa()).build());
		
		return urlNuevaOferta;
	}
	
	@PostMapping(value = "/ofertas/nueva/save")
	public String crearnuevaOferta(@Valid OfertaPractica oferta, 
			BindingResult bindingResult,Authentication authentication) {
		
		if(bindingResult.hasErrors()) {
			return urlNuevaOferta;
		}
		
		adminServices.publicarOferta(oferta, authentication);
		
		
		return new StringBuilder( urlredirectOfertaCreada)
				.append(oferta.getCarrera().getId())
				.toString();
	}
	
	
	@GetMapping(value = "/ofertas/actualizar/{id}")
	public String actualizarOferta(@PathVariable(name = "id")Long id, Model model) {
		
		OfertaPractica oferta= ofertaServices.getOfertaById(id);
		
		model.addAttribute("oferta", oferta);

		return urlActualizarOferta;
	}
	
	

	@GetMapping(value = "/ofertas/eliminar/{id}")
	public String actualizarOferta(@PathVariable(name = "id")Long id) {
		
		adminServices.eliminarOferta(id);
		
		return new StringBuilder( urlredirectOfertaCreada)
				.append(id)
				.toString();
	}
	
	
	@PostMapping(value = "/ofertas/actualizar")
	public String actualizarOferta(@Valid OfertaPractica oferta, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return urlNuevaOferta;
		}
		
		adminServices.actualizarOferta(oferta);
		
		
		return new StringBuilder( urlredirectOfertaCreada)
				.append(oferta.getCarrera().getId())
				.toString();
	}
	
	
	
	
	@ModelAttribute
	public void atributes(Model model) {
		model.addAttribute("empresas", empresaServices.getEmpresas());
		
		model.addAttribute("carreras", carreraServices.getCarreras());
	}
	
	

	
	private final String urlNuevaOferta="ofertas/FormOf";
	private final String urlActualizarOferta="ofertas/FormOfactualizar";
	private final String urlredirectOfertaCreada="redirect:/tecnopracticas/carrera/ofertas/";
	
	
	@Autowired
	private EmpresaServices empresaServices;
	
	@Autowired
	private OfertaServices ofertaServices;
	
	@Autowired
	private CarreraServices carreraServices;
	
	@Autowired
	private AdminServices adminServices;
}
