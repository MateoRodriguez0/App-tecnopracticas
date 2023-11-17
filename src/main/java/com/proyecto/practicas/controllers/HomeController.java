package com.proyecto.practicas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class HomeController {

    @GetMapping(value = "/")
    public String paginaPrincipal(){

        return pagPrincipal;
    }


    @GetMapping(value = "/programas")
    public String carrerasDisponibles(){

        return pagPracticas;
    }

    private static final String pagPrincipal="principal/home";
    
    private static final String pagPracticas="CarrerasDisp/CarrerasDisp";
}
