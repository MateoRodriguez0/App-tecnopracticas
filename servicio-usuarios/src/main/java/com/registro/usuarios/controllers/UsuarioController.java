package com.registro.usuarios.controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
    	ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
    	node.put("status", 200);
    	node.put("message",usuarioService.registarUsuario(usuario));
    	return ResponseEntity.ok(node);
    }
    /*@PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@RequestParam String email,
                                                    @RequestParam String password,
                                                    @RequestParam String nombre) {
        try {
            Usuario usuario = usuarioService.registrarUsuario(email, password, nombre);
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        } catch (EmailExistException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }*/
    
    
    /*@GetMapping(value = "/user/{email}")
    public ResponseEntity<?> getMethodName(@PathVariable("email") String email) {
    	
        return client.enviarCorreo(email);
    }*/

}