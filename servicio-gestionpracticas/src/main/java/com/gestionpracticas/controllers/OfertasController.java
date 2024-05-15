package com.gestionpracticas.controllers;


import com.gestionpracticas.model.Ofertas;
import com.gestionpracticas.services.OfertasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ofertas")
public class OfertasController {
    private final OfertasService ofertasService;

    @Autowired
    public OfertasController(OfertasService ofertasService) {
        this.ofertasService = ofertasService;
    }

    @GetMapping
    public ResponseEntity<List<Ofertas>> getAllOfertas() {
        return ResponseEntity.ok(ofertasService.getAllOfertas());
    }

    @PostMapping("/create")
    public ResponseEntity<Ofertas> createOferta(@RequestBody Ofertas ofertas) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ofertasService.createOferta(ofertas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ofertas> getOferta(@PathVariable UUID id) {
        return ResponseEntity.ok(ofertasService.getOferta(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ofertas> updateOferta(@PathVariable UUID id, @RequestBody Ofertas ofertas) {
        return ResponseEntity.ok(ofertasService.updateOferta(ofertas));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOferta(@PathVariable UUID id) {
        ofertasService.deleteOferta(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/carreras/{carreraId}")
    public ResponseEntity<List<Ofertas>> getOfertasByCarrera(@PathVariable UUID id) {
        return ResponseEntity.ok(ofertasService.getOfertasByCarrera(id));
    }
}