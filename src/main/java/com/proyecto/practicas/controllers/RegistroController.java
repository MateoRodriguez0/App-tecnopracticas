package com.proyecto.practicas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.practicas.feignclients.VerificacionEmailClient;
import com.proyecto.practicas.models.Usuario;
import com.proyecto.practicas.models.VerificationCode;
import com.proyecto.practicas.services.RolServices;
import com.proyecto.practicas.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class RegistroController {

    @GetMapping(value = "/cuentas/singup")
    public String getFormSingUp(Usuario usuario){

        return urlFormularioSingUP;
    }

    
    @PostMapping(value = "/cuentas/Singup")
    public String crearCuenta(@Valid Usuario usuario,BindingResult bindingResult,Model model) {
		
    	if(bindingResult.hasErrors() || !usuario.validPasword() ||
    			userService.ExistUserByEmail(usuario.getEmail())|| usuario.esMayordeEdad()) {
    		
    		return urlFormularioSingUP;
    	}
    	
    	
    	userService.registrarUsuario(usuario);
    	
    	if(emailClient.enviarCorreo(usuario.getEmail()).getStatusCode().equals(HttpStatus.NO_CONTENT)) {
    		
    		model.addAttribute("emailConValidacionPendiente", usuario.getEmail());
    		
    		return redirecturlFormularioVerificacionEmail;
    	}
    	
    	return urlFormularioSingUP;
    	
    	
    }
    
    
    @GetMapping(value = "/cuentas/Singup/verificacion")
    public String verificarEmail(VerificationCode verificationCode, Model model) {
    	
    	String email=model.getAttribute("emailConValidacionPendiente").toString();
    	verificationCode=VerificationCode.builder()
    			.email(email)
    			.build();
    	
    	return urlVerificacionEmail;
    	
    	
    	
    }
    
    
    
    @PostMapping(value = "/cuentas/Singup/verificacion")
    public String verificarEmail(@Valid VerificationCode verificationCode,
    		BindingResult bindingResult, Model model) {
    	
    	if(bindingResult.hasErrors()||
    			!emailClient.verifierCode(verificationCode)
			    	.getStatusCode()
			    	.equals(HttpStatus.OK)) {
    		
    		return redirecturlFormularioVerificacionEmail;
    	}
    	
    	emailClient.accountCreated(verificationCode.getEmail());
    	
    	return urlFormularioLogin;
    }
    
    
    
    
	@ModelAttribute
	public void atributes(Model model) {
		model.addAttribute("roles",rolServices.getRoles());
	}
	
	
	
	
	
	
	
    
    @Autowired
    private UserService userService;
    
    @Autowired 
    private RolServices rolServices;
    
    @Autowired
    private VerificacionEmailClient emailClient;
    
    private static final String urlVerificacionEmail="";
    private static final String redirecturlFormularioVerificacionEmail="redirect:tecnopracticas/cuentas/Singup/verificacion";
    private static final String urlFormularioSingUP="Formularios/Register/Register";
    private static final String urlFormularioLogin="Formularios/Login/Login";
}
