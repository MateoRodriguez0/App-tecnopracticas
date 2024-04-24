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
public class RegistroService {
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

 
    public String registarUsuario(Usuario usuario) {
		String encodedEmail =Base64.getEncoder().encodeToString(usuario.getCorreo().getBytes());
		String token= null;
		String codigo=generarCodigo(usuario.getCorreo());

		
    	if(!usuarioRepository.existsByCorreo(usuario.getCorreo())) {
    		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    		usuario.setFecha_registro(Timestamp.from(Instant.now()));
    		usuario.setVerificado(false);
    		usuario.setRoles(List.of(rolesRepository.findByNombre("ESTUDIANTE")));
    		token= codigo+"-"+encodedEmail;
    		Verificacion verificacion = Verificacion.builder()
    				.email(usuario.getCorreo())
    				.codigo(codigo)
    				.expiracion(Date.from(Instant.now().plus(10, ChronoUnit.MINUTES)))
    				.tipo(TipoVerification.cuenta)
    				.build();

    		Usuario registrado=usuarioRepository.save(usuario);
    		
    		verificacionRepository.save(verificacion);
    		boolean enviado=client.VerificarCuenta(registrado.getCorreo(),token).getBody();
    		if(enviado) {
    			return "Cuenta registrada, correo de verificacion enviado.";
    		}
    	}
    	
    	if(usuarioRepository.existsByCorreo(usuario.getCorreo())&& 
    			! usuarioRepository.correoVerificado(usuario.getCorreo())) {
    		boolean tokenValido=isvalidToken(verificacionRepository.getExpirationByEmail(usuario.getCorreo(),
					TipoVerification.cuenta.toString()));
    		
    		Verificacion verificacion = verificacionRepository
    				.findByEmailAndTipo(usuario.getCorreo(), TipoVerification.cuenta.toString());
    		if(!tokenValido) {
    			verificacion.setExpiracion(Date.from(Instant.now().plus(10, ChronoUnit.MINUTES)));	
    		}
    		verificacion.setCodigo(codigo);
    		token=codigo+"-"+encodedEmail;
    		usuario.setId(usuarioRepository.getIdByCorreo(usuario.getCorreo()));
    		usuarioRepository.save(usuario);
    		boolean enviado=client.VerificarCuenta(usuario.getCorreo(),token).getBody();
    		if(enviado) {
    			return "La cuenta ya se encontraba registrada,"
    					+ " correo de verificacion enviado.";
    		}
    	}		
    	return "El correo electronico ya se encuentra registrado.";	
    }


    @Transactional
    public String verificarCuenta(String token) {
    	String [] parts= token.split("-");
    	byte[] DecoderEmail=Base64.getDecoder().decode(parts[1]);
    	String email= new String(DecoderEmail);
    	
    	if(usuarioRepository.existsByCorreo(email)) {
    		if(!usuarioRepository.correoVerificado(email)) {
        		Verificacion verificacion= verificacionRepository
            			.findByCorreoAndCodigo(email, parts[0]);
            	if(verificacion != null) {
            		if(isvalidToken(verificacion.getExpiracion())) {
            			usuarioRepository.validarCorreo(email);
            			verificacionRepository
            			.eliminarVerificacionCuenta(email, TipoVerification.cuenta.toString());
            			client.cuentaVerificada(email);
            			
            			return "Cuenta verificada";
            		}
            		else{
            			return "token caducado";
            			}
            		}
            	}
    		}
    	return "token invalido";
    }
    
	private boolean isvalidToken(Date date ){
		return date.after(new Date());
	}
    
    
    private String generarCodigo(String email) {
		String sha256hex = Hashing.sha512()
				  .hashString(email+new Date().toString(), StandardCharsets.UTF_8)
				  .toString();
		return sha256hex;
		
	}
    
    
	   
   
}
