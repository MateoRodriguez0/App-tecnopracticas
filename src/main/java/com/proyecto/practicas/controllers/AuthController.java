package com.proyecto.practicas.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/tecnopracticas")
public class AuthController {
	
    private static final String urlFormularioLogin="Formularios/Login/Login";
   
    private static final String urlRedirectCarreras="redirect:/tecnopracticas/programas";
 
	

    @GetMapping(value = "/cuentas/login")
    public String getFormLogin(){

        return urlFormularioLogin;
    }




    @PostMapping(value = "/login/auth")
    public String authenticated() {
    	
    	return urlRedirectCarreras;
    }
	

    
   
}
