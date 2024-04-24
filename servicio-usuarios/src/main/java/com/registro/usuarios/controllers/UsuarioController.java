package com.registro.usuarios.controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private RegistroService registroService;
    

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
    	ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
    	node.put("status", 200);
    	node.put("message",registroService.registarUsuario(usuario));
    	return ResponseEntity.ok(node);
    }
    
    @GetMapping("/verificar")
    public ResponseEntity<?> verificarUsuario(@RequestParam String token) {
    	ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
    	node.put("status", 200);
    	node.put("message",registroService.verificarCuenta(token));
    	return ResponseEntity.ok(node);
    }
    
    
  

}