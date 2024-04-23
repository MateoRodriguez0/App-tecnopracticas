package com.registro.usuarios.services;

import com.registro.usuarios.exception.EmailExistException;
import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Transactional
    public boolean validatePasswordResetToken(String token) {
        Usuario usuario = usuarioRepository.findByPasswordResetToken(token);
        if (usuario != null) {
            LocalDateTime expiration = usuario.getPasswordResetTokenExpiration();
            LocalDateTime now = LocalDateTime.now();
            return expiration != null && expiration.isAfter(now);
        }
        return false;
    }
    @Transactional
    public void updatePassword(String token, String newPassword) {
        Usuario usuario = usuarioRepository.findByPasswordResetToken(token);
        if (usuario != null) {
            usuario.setPassword(passwordEncoder.encode(newPassword));
            usuario.setPasswordResetToken(null);
            usuarioRepository.save(usuario);
        }
    }
}
