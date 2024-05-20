package com.gestionpracticas.controllers;

import com.gestionpracticas.model.Carreras;
import com.gestionpracticas.services.CarrerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/carreras")
@CrossOrigin(origins = "*")
public class CarrerasController {
    @Autowired
    private CarrerasService carrerasService;

    @GetMapping
    public List<Carreras> getAllCarreras() {
        return carrerasService.getAllCarreras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carreras> getCarreraById(@PathVariable UUID id) {
        Optional<Carreras> carrera = carrerasService.getCarreraById(id);
        if (carrera.isPresent()) {
            return ResponseEntity.ok(carrera.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
