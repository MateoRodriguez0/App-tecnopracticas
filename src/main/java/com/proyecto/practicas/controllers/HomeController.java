package com.proyecto.practicas.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class HomeController {

    @GetMapping(value = "/home")
    public String paginaPrincipal(){

        return pagPrincipal;
    }



    private static final String pagPrincipal="home";
}
