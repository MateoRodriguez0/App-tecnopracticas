package com.serviciopostulacion.controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.serviciopostulacion.model.Oferta;
import com.serviciopostulacion.model.Postulacion;
import com.serviciopostulacion.services.PostulacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/postulaciones")
public class PostulacionController {
    @Autowired
    private PostulacionService postulacionService;

    @GetMapping
    public List<Postulacion> obtenerTodasLasPostulaciones() {
        return postulacionService.listarPostulaciones();
    }

    @GetMapping("/{id}")
    public Postulacion obtenerPostulacionPorId(@PathVariable UUID id) {
        return postulacionService.obtenerPostulacionPorId(id);
    }
    
    @GetMapping("/empresa/{id}")
    public List<Postulacion> obtenerPostulacionPorEmpresa(@PathVariable UUID id) {
        return postulacionService.obtenerPostulacionesPorEmpresa(id);
    }
    
    @GetMapping("/carrera/{id}")
    public List<Postulacion> obtenerPostulacionPorCarrera(@PathVariable UUID id) {
        return postulacionService.obtenerPostulacionesPorCarrera(id);
    }

    //Recibir el id del usuario que se postula, por cabecera
    @PostMapping("/crear")
    public ResponseEntity<?> postularse(@RequestHeader("id") UUID Id, @RequestBody Oferta oferta) {
    	ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("status", "200");
        node.put("message", postulacionService.crearPostulacion(Id,oferta));
        return ResponseEntity.status(HttpStatus.OK).body(node);
    }

    @PutMapping("/{id}")
    public Postulacion actualizarPostulacion(@PathVariable UUID id, 
    			@RequestBody Postulacion postulacion) {
        postulacion.setId(id);
        return postulacionService.actualizarPostulacion(postulacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarPostulacion(@PathVariable UUID id) {
        postulacionService.eliminarPostulacion(id);
    }

    @PutMapping("/{id}/aprobar")
    public ResponseEntity<?> aprobarPostulacion(@PathVariable UUID id) {
    	ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("status", "200");
        node.put("message", postulacionService.aprobarPostulacion(id));
        return ResponseEntity.status(HttpStatus.OK).body(node);
    }

    @PutMapping("/{id}/descartar")
    public ResponseEntity<?> rechazarPostulacion(@PathVariable UUID id) {
    	ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("status", "200");
        node.put("message", postulacionService.rechazarPostulacion(id));
        return ResponseEntity.status(HttpStatus.OK).body(node);
      
    }

    @PutMapping("/{id}/revision")
    public ResponseEntity<?> cambiarEstadoPostulacion(@PathVariable UUID id) {
    	ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("status", "200");
        node.put("message", postulacionService.RevisarPostulacion(id));
        return ResponseEntity.status(HttpStatus.OK).body(node);
    }

    @GetMapping("/usuario/{id}")
    public Optional<Postulacion> getPostulacionesByUsuarioId(@PathVariable(name = "id") UUID Id) {
        return postulacionService.getPostulacionesById(Id);
    }

}