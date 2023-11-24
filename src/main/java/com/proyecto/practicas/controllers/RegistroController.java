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

import feign.FeignException;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class RegistroController {

    @GetMapping(value = "/cuentas/singup")
    public String getFormSingUp(Usuario usuario){

        return urlFormularioSingUP;
    }

    
    @PostMapping(value = "/cuentas/singup")
    public String crearCuenta(@Valid Usuario usuario,BindingResult bindingResult,Model model) {
		
    	if(bindingResult.hasErrors() || !usuario.validPasword() ||
    			userService.ExistUserByEmail(usuario.getEmail())|| !usuario.esMayordeEdad()) {
    		
    		return urlFormularioSingUP;
    	}
   
    	
    	
    	try {
    		
    		usuario.setEnable(false);
    		userService.registrarUsuario(usuario);
    		
    		emailClient.enviarCorreo(usuario.getEmail());
    		
    		
    		VerificationCode verificationCode=VerificationCode.builder().email(usuario.getEmail()).build();
    		model.addAttribute("verificationCode",verificationCode);
    		
    		
    		return redirecturlFormularioVerificacionEmail;
    		
    	}catch (FeignException e) {
    		return urlFormularioSingUP;
		}
    	
    	
    }
    
    
    @GetMapping(value = "/cuentas/singup/verificacion")
    public String verificarEmail(VerificationCode verificationCode, Model model) {
    	
    	verificationCode=(VerificationCode) model.getAttribute("verificationCode");
    	/*
    	String email=(String) model.getAttribute("emailConValidacionPendiente");
    	verificationCode=VerificationCode.builder()
    			.email(email)
    			.build();
    	model.addAttribute("verificationCode", verificationCode);
    	*/
    	
    	
    	return urlVerificacionEmail;
    	
    	
    	
    }
    
    
    
    @PostMapping(value = "/cuentas/auth/verificacion")
    public String verificarEmail(@Valid VerificationCode verificationCode,
    		BindingResult bindingResult, Model model) {
    	
    	System.out.println(verificationCode);
    	if(bindingResult.hasErrors()||
    			!emailClient.verifierCode(verificationCode)
			    	.getStatusCode()
			    	.equals(HttpStatus.OK)) {
    		
    		return redirecturlFormularioVerificacionEmail;
    	}
    	
    	
    	if(emailClient.verifierCode(verificationCode).getStatusCode()== HttpStatus.OK) {
    	
    		System.out.println("ws");
    		userService.activarCuenta(verificationCode.getEmail());
    		
    		emailClient.accountCreated(verificationCode.getEmail());
    	}
    	
    	
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
    
    private static final String urlVerificacionEmail="Formularios/verificacion/verificacion";
    private static final String redirecturlFormularioVerificacionEmail="redirect:/tecnopracticas/cuentas/singup/verificacion";
    private static final String urlFormularioSingUP="Formularios/Register/Register";
    private static final String urlFormularioLogin="Formularios/Login/Login";
}
