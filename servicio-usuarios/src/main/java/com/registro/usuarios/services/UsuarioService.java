package com.registro.usuarios.services;

import com.registro.usuarios.exception.EmailExistException;
import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Usuario registrarUsuario(String email, String password, String nombre) {
        if (usuarioRepository.existsByCorreo(email)) {
            throw new EmailExistException("El correo electrónico ya existe.");
        }

        Usuario usuario = new Usuario();
        usuario.setCorreo(email);
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setNombre(nombre);

        return usuarioRepository.save(usuario);
    }
}
