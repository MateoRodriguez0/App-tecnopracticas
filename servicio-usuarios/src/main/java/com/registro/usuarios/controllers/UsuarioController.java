package com.registro.usuarios.controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.registro.usuarios.models.RestablecerClave;
import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.services.ClaveService;
import com.registro.usuarios.services.RegistroService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private RegistroService registroService;
    
    @Autowired
    private ClaveService claveService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody Usuario usuario, BindingResult result) {
    	ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
    	node.put("status", 200);
    	if(!usuario.passwordIsValid()) {
    		node.put("error_password", "la clave no cumple con los requisitos");
    	}
    	if(result.hasErrors()|| !usuario.passwordIsValid()) {
    		for (ObjectError error : result.getAllErrors()) {
    			node.put("error_"+error.getCode(), error.getDefaultMessage());
			}
    	
    		return ResponseEntity.ok(node);
    	}
    	
    	try {
			node.put("message",registroService.registarUsuario(usuario));
		} catch (Exception e) {
			node.put("message","Error");
			e.printStackTrace();
		}
    	return ResponseEntity.ok(node);
    }
    
    @GetMapping("/verificar")
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
    
    @PostMapping("/restablecer-clave")
    public ResponseEntity<?> restablecerClave(@RequestBody RestablecerClave clave) {
    	ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
    	node.put("status", 200);
    	node.put("message",claveService.RestablecerClave(clave));
    	return ResponseEntity.ok(node);
    }
       
}