package com.registro.usuarios.controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.registro.usuarios.models.RestablecerClave;
import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.services.ClaveService;
import com.registro.usuarios.services.CurriculumServices;
import com.registro.usuarios.services.RegistroService;
import com.registro.usuarios.services.UsuarioService;

import jakarta.validation.Valid;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UsuarioController {
    @Autowired
    private RegistroService registroService;
    
    @Autowired
    private ClaveService claveService;
    
    @Autowired
    private CurriculumServices curriculumServices;
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody Usuario usuario, BindingResult result) {
    	ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
    	node.put("status", 200);    	
    	try {
			node.put("message",registroService.registarUsuario(usuario));
		} catch (Exception e) {
			node.put("message","Error");
			e.printStackTrace();
		}
    	return ResponseEntity.ok(node);
    }
    
    @PutMapping("/verificar")
    public ResponseEntity<?> verificarUsuario(@RequestParam String token) {
    	ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
    	node.put("status", 200);
    	node.put("message",registroService.verificarCuenta(token));
    	return ResponseEntity.ok(node);
    }
    
    @GetMapping("/restablecer-clave")
    public ResponseEntity<?> restablecerClave(@RequestParam String email) {
    	ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
    	node.put("status", 200);
    	node.put("message",claveService.enviarEnlaceRestablecerClave(email));
    	return ResponseEntity.ok(node);
    }
    
    @PutMapping("/restablecer-clave")
    public ResponseEntity<?> restablecerClave(@RequestBody RestablecerClave clave) {
    	ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
    	node.put("status", 200);
    	node.put("message",claveService.RestablecerClave(clave));
    	return ResponseEntity.ok(node);
    }
    
    @PostMapping("/curriculum/guardar")
    public ResponseEntity<?> guardarCurriculo(@RequestParam("file") MultipartFile multipartFile,
    		@RequestParam(required = false) UUID id,
    		@RequestHeader(required = false, name = "id") UUID idH) {
    	ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
    	node.put("status", 200);
    	if(id!=null) {
    		node.put("message",curriculumServices.guardarCv(multipartFile, id));
    	}
    	else {
    		node.put("message",curriculumServices.guardarCv(multipartFile, idH));
    	}
    	return ResponseEntity.ok(node);
    }
    
    @GetMapping(value = {"/curriculum/buscar", "/curriculum/me"})
    public ResponseEntity<?> buscarCurriculo(@RequestParam(required = false, name = "id") UUID id,
    		@RequestParam(required = false, name = "user") UUID userId,
    		@RequestHeader(name = "id", required = false) UUID header_id) {
    	UUID idToSearch = userId != null ? userId : (header_id != null ? header_id : id);
    	Resource resource=curriculumServices.buscarCv(idToSearch);
    	return ResponseEntity.ok()
    			.contentType(MediaType.APPLICATION_PDF)
    			.body(resource);
    }
    
    @GetMapping("/info-me")
    public ResponseEntity<?> getInfoUsuario(@RequestHeader(name = "id", required = false) UUID id){
    	return  ResponseEntity.ok(usuarioService.getInfo(id)); 
    }
    
    
       
}