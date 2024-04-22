package com.registro.usuarios.controllers;
import com.registro.usuarios.exception.EmailExistException;
import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.repositories.UsuarioRepository;
import com.registro.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@RequestParam String email,
                                                    @RequestParam String password,
                                                    @RequestParam String nombre) {
        try {
            Usuario usuario = usuarioService.registrarUsuario(email, password, nombre);
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        } catch (EmailExistException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    
    
   /* @GetMapping(value = "/user/{email}")
    public Usuario getMethodName(@PathVariable("email") String email) {
    	Usuario usuario= usuarioRepository.findByCorreo(email);
        return usuario;
    }*/
    
    
    @Autowired
    private UsuarioRepository usuarioRepository;
}