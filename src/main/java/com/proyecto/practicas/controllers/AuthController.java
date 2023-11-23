package com.proyecto.practicas.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
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




    @GetMapping(value = "/cuentas/login/auth")
    public String authenticated(Authentication authentication,HttpSession  httpSession) {
    	
    	
    	
    	return urlRedirectCarreras;
    }

    
    @PostMapping("/logout")
    public RedirectView logout (HttpServletRequest request, HttpSession session) {
    	
    		
    	// Invalida la sesión actual
    	if(session != null) {
    			session.invalidate();
    		}
    		
    		
    	//// Borra la autenticación actual 
    	SecurityContextHolder.clearContext();
    		
    		
    		return new RedirectView("");
    	}
    

    
   
}
