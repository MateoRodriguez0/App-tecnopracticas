package com.gestionpracticas.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gestionpracticas.model.Carreras;
import com.gestionpracticas.model.Empresas;
import com.gestionpracticas.model.Ofertas;
import com.gestionpracticas.repositories.OfertasRepository;
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

    private final OfertasRepository ofertasRepository;

    @Autowired
    public OfertasController(OfertasService ofertasService, OfertasRepository ofertasRepository) {
        this.ofertasService = ofertasService;
        this.ofertasRepository = ofertasRepository;
    }

    @GetMapping
    public ResponseEntity<List<Ofertas>> getAllOfertas() {
        return ResponseEntity.ok(ofertasService.getAllOfertas());
    }

    @GetMapping("/{id}") public ResponseEntity<Ofertas> getOferta(@PathVariable UUID id) {
        return ResponseEntity.ok(ofertasService.getOferta(id));
    }

    @PostMapping("/create")
    public ResponseEntity<JsonNode> createOferta(@RequestBody Ofertas ofertas) {
        ofertasService.createOferta(ofertas);
        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("status", "201");
        node.put("message", "OFERTA_CREADA_EXITOSAMENTE");
        return ResponseEntity.status(HttpStatus.CREATED).body(node);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JsonNode> updateOferta(@PathVariable UUID id, @RequestBody Ofertas ofertas) {
        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("status", "200");
        node.put("message", "OFERTA_ACTUALIZADA");
        return ResponseEntity.ok(node);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JsonNode> deleteOferta(@PathVariable UUID id) {
        try {
            ofertasService.deleteOferta(id);
            ObjectNode node = JsonNodeFactory.instance.objectNode();
            node.put("status", "200");
            node.put("message", "OFERTA_ELIMINADA");
            return ResponseEntity.ok().body(node);
        } catch (Exception e) {
            ObjectNode errorNode = JsonNodeFactory.instance.objectNode();
            errorNode.put("status", "200");
            errorNode.put("message", "ERROR_NO_SE_PUEDE_ELIMINAR");
            return ResponseEntity.status(200).body(errorNode);
        }
    }

    @GetMapping("/empresa/{id}")
    public List<Ofertas> getOfertasByEmpresa(@PathVariable UUID id) {
        return ofertasService.getOfertasByEmpresas(id);
    }

    @GetMapping("/carrera/{id}")
    public List<Ofertas> getOfertasByCarrera(@PathVariable UUID id) {
        return ofertasService.getOfertasByCarreras(id);
    }
}
