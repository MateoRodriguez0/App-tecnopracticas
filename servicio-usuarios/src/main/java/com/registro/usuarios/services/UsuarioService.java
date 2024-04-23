package com.registro.usuarios.services;

import com.registro.usuarios.models.TipoVerification;
import com.google.common.hash.Hashing;
import com.registro.usuarios.clients.MensajeriaClient;
import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.models.Verificacion;
import com.registro.usuarios.repositories.RolesRepository;
import com.registro.usuarios.repositories.UsuarioRepository;
import com.registro.usuarios.repositories.VerificacionRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MensajeriaClient client;
    @Autowired
    private VerificacionRepository verificacionRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Transactional
    public boolean registarUsuario(Usuario usuario) {
    	if(!usuarioRepository.existsByCorreo(usuario.getCorreo())) {
    		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    		usuario.setFecha_registro(Timestamp.from(Instant.now()));
    		usuario.setVerificado(false);
    		usuario.setRoles(List.of(rolesRepository.findByNombre("ESTUDIANTE")));
    		Date expiration = Date.from(Instant.now().plus(10, ChronoUnit.MINUTES));
    		String codigo=generarCodigo(usuario.getCorreo());
    		String encodedEmail =Base64.getEncoder().encodeToString(usuario.getCorreo().getBytes());
    		
    		Verificacion verificacion = Verificacion.builder()
    				.email(usuario.getCorreo())
    				.codigo(codigo)
    				.expiracion(expiration)
    				.tipo(TipoVerification.cuenta)
    				.build();
    		
    		if(verificacionRepository.existsByEmail(usuario.getCorreo())) {
    			verificacion =verificacionRepository.findByEmail(usuario.getCorreo());
    			verificacion.setCodigo(codigo);
    			verificacion.setExpiracion(expiration);
    			
    		}
    		
    		String token= codigo+"-"+encodedEmail;
    		usuarioRepository.save(usuario);
    		verificacionRepository.save(verificacion);
    		
    		return client.VerificarCuenta(usuario.getCorreo(),token).getBody();
    	}
    	
    	
    	
    	
    	return false;
    	
    	
    	
    }
    
    
   /** public Usuario registrarUsuario(String email, String password, String nombre) {
        if (usuarioRepository.existsByCorreo(email)) {
            throw new EmailExistException("El correo electrónico ya existe.");
        }

        Usuario usuario = new Usuario();
        usuario.setCorreo(email);
        usuario.setPassword(passwordEncoder.encode(password));
        usuario.setNombre(nombre);

        return usuarioRepository.save(usuario);
    }
**/
   /* @Transactional
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
    }*/
    
    private String generarCodigo(String email) {
		String sha256hex = Hashing.sha512()
				  .hashString(email, StandardCharsets.UTF_8)
				  .toString();
		return sha256hex;
		
	}
	   
   
}
