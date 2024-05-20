package com.gestionpracticas.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gestionpracticas.model.Empresas;
import com.gestionpracticas.services.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {

    @Autowired
    private EmpresasService empresasService;

    @GetMapping
    public List<Empresas> getAllEmpresas() {
        return empresasService.getAllEmpresas();
    }

    @GetMapping("/{id}")
    public Empresas getEmpresaById(@PathVariable UUID id) {
    	return empresasService.getEmpresaById(id);
    	}

    @PostMapping("/create")
    public ResponseEntity<JsonNode> createEmpresa(@RequestBody Empresas empresas) {
        Empresas nuevaEmpresa = empresasService.createEmpresa(empresas);

        ObjectNode responseNode = new ObjectNode(JsonNodeFactory.instance);
        responseNode.put("status", "200");
        responseNode.put("message", "EMPRESA_CREADA");
        responseNode.putPOJO("body", nuevaEmpresa);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseNode);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JsonNode> updateEmpresa(@PathVariable UUID id, @RequestBody Empresas empresas) {
        Empresas empresaActualizada = empresasService.updateEmpresa(id, empresas);

        ObjectNode responseNode = new ObjectNode(JsonNodeFactory.instance);
        responseNode.put("status", "200");
        responseNode.put("message", "EMPRESA_ACTUALIZADA");
        responseNode.putPOJO("body", empresaActualizada);

        return ResponseEntity.ok(responseNode);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JsonNode> deleteEmpresa(@PathVariable UUID id) {
        try {
            empresasService.deleteEmpresa(id);
            ObjectNode node = JsonNodeFactory.instance.objectNode();
            node.put("status", "200");
            node.put("message", "EMPRESA_ELIMINADA");
            return ResponseEntity.ok().body(node);
        } catch (Exception e) {
            ObjectNode errorNode = JsonNodeFactory.instance.objectNode();
            errorNode.put("status", "200");
            errorNode.put("message", "ERROR_NO_SE_PUEDE_ELIMINAR");
            return ResponseEntity.status(200).body(errorNode);
        }
    }
}
