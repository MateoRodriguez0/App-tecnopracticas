package com.gestionpracticas.controllers;

import com.gestionpracticas.model.Carreras;
import com.gestionpracticas.model.Facultades;
import com.gestionpracticas.services.FacultadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/facultades")
public class FacultadesController {

    @Autowired
    private FacultadesService facultadesService;

    @GetMapping
    public List<Facultades> getAllFacultades() {
        return facultadesService.getAllFacultades();
    }

    @GetMapping("/{id}/carreras")
    public List<Carreras> getCarrerasByFacultadesId(@PathVariable UUID id) {
        return facultadesService.getCarrerasByFacultadesId(id);
    }
}
