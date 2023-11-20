package com.proyecto.practicas.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.practicas.models.Carrera;
import com.proyecto.practicas.services.CarreraServices;

import java.util.*;


@Controller
@RequestMapping(value = "/tecnopracticas")
public class HomeController {

    @GetMapping(value = "/")
    public String paginaPrincipal(){

        return pagPrincipal;
    }


    @GetMapping(value = "/programas")
    public String carrerasDisponibles(Model model){

    	List<Carrera> carreras=carreraServices.getCarreras();
    	
    	model.addAttribute("carreras", carreras);
    	
        return pagPracticas;
    }

    private static final String pagPrincipal="principal/home";
    
    private static final String pagPracticas="CarrerasDisp/CarrerasDisp";
    
    @Autowired
    private CarreraServices carreraServices;
    
}
