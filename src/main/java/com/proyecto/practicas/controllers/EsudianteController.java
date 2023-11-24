package com.proyecto.practicas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import com.proyecto.practicas.models.Postulacion;
import com.proyecto.practicas.models.Usuario;
import com.proyecto.practicas.services.EstudianteServices;
import com.proyecto.practicas.services.OfertaServices;
import com.proyecto.practicas.services.UserService;


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
	
	
	
	@GetMapping(value = "/oferta/{id}/postulacion/nueva")
	public RedirectView savePostulcion(@PathVariable(name = "id")Long idOferta,Authentication authentication, Model model) {
		
		estudianteServices.guardarPostulacion(ofertaServices.getOfertaById(idOferta), authentication);
		
		return new RedirectView(RedirectPerfil);
	}
	
	
	
	@GetMapping(value = "/postulaciones/eliminar/{id}")
	public String eliminarPostulacion(@PathVariable(name = "id")Long id){
		
		estudianteServices.eliminarPostulacion(id);
	
		return urlRedirectpostulaciones;
	}
	
	
	
	private final String urlPostulaciones="redirect:/tecnopracticas/myaccount";
	
	private final String urlRedirectpostulaciones="redirect:/tecnopracticas/estudiante/postulaciones";
	
	private final String RedirectPerfil="/tecnopracticas/myaccount";
	
	@Autowired
	private OfertaServices ofertaServices;

	
	@Autowired
	private EstudianteServices estudianteServices;
	
	@Autowired
	private UserService userService;
	
	
}

