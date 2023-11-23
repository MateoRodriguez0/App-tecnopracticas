package com.proyecto.practicas.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/tecnopracticas")
public class AuthController {
	
    private static final String urlFormularioLogin="Formularios/Login/Login";
   
    private static final String urlRedirectCarreras="redirect:/tecnopracticas/programas";
 
	

    @GetMapping(value = "/cuentas/login")
    public String getFormLogin(){
    	
 

        return urlFormularioLogin;
    }




    @PostMapping(value = "/cuentas/login/auth")
    public String authenticated(Authentication authentication ,HttpSession  httpSession) {
    	
    	System.out.println(authentication.getName());
    	
    	return urlRedirectCarreras;
    }
	
    


    
   
}
