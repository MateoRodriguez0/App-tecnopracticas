package com.serviciopostulacion.controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.serviciopostulacion.model.EstadoPostulacion;
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

    //Recibir el id del usuario que se postula, por cabecera
    @PostMapping("/crear")
    public ResponseEntity<?> postularse(@RequestHeader("Id") UUID Id, @RequestBody Oferta oferta) {
    	ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("status", "200");
        node.put("message", postulacionService.crearPostulacion(Id,oferta));
        return ResponseEntity.status(HttpStatus.OK).body(node);
    }

    @PutMapping("/{id}")
    public Postulacion actualizarPostulacion(@PathVariable UUID id, @RequestBody Postulacion postulacion) {
        postulacion.setId(id);
        return postulacionService.actualizarPostulacion(postulacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarPostulacion(@PathVariable UUID id) {
        postulacionService.eliminarPostulacion(id);
    }

    @PutMapping("/{id}/aprobar")
    public Postulacion aprobarPostulacion(@PathVariable UUID id) {
        return postulacionService.aprobarPostulacion(id);
    }

    @PutMapping("/{id}/rechazar")
    public Postulacion rechazarPostulacion(@PathVariable UUID id) {
        return postulacionService.rechazarPostulacion(id);
    }

    @PutMapping("/{id}/cambiar-estado")
    public Postulacion cambiarEstadoPostulacion(@PathVariable UUID id, @RequestBody EstadoPostulacion estado) {
        return postulacionService.cambiarEstadoPostulacion(id, estado);
    }

    @GetMapping("/usuario/{usuarioId}")
    public Optional<Postulacion> getPostulacionesByUsuarioId(@PathVariable UUID Id) {
        return postulacionService.getPostulacionesById(Id);
    }

}