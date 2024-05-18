package com.registro.usuarios.services;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.registro.usuarios.clients.MensajeriaClient;
import com.registro.usuarios.models.RestablecerClave;
import com.registro.usuarios.models.TipoVerification;
import com.registro.usuarios.models.Verificacion;
import com.registro.usuarios.repositories.UsuarioRepository;
import com.registro.usuarios.repositories.VerificacionRepository;

import jakarta.transaction.Transactional;

@Service
public class ClaveService {
	@Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MensajeriaClient client;
    @Autowired
    private VerificacionRepository verificacionRepository;

    
    @Transactional
    public String RestablecerClave(RestablecerClave clave) {
    	if(!clave.getToken().matches("([a-z0-9]+)-([a-zA-Z0-9]+)==")) {
    		return "TokenInvalido";
    	}
    	
    	String [] parts= clave.getToken().split("-");
    	byte[] DecoderEmail=Base64.getDecoder().decode(parts[1]);
    	String email= new String(DecoderEmail);
    	
    	
    	if(usuarioRepository.existsByCorreo(email)) {
    		Verificacion verificacion= verificacionRepository
        			.findByCorreoAndCodigo(email, parts[0]);
    		if(verificacion != null) {
        		if(isvalidToken(verificacion.getExpiracion())) {
        			usuarioRepository
        				.restablecerclave(passwordEncoder.encode(clave.getClave_nueva()), email);
        			verificacionRepository
        				.eliminarVerificacionCuenta(email, TipoVerification.clave.toString());
					try {
						client.claveRestablecida(email);
					} catch (Exception e) {
						if(e.getCause().getClass()==java.net.SocketTimeoutException.class) {}
					}
        			
        			return "ClaveRestablecida";
        		}
        		else {
        			return "TokenCaducado";
        			}
        		}
    	}
		return "TokenInvalido";
	}
    
	
	public String enviarEnlaceRestablecerClave(String correo) {
    	if(usuarioRepository.existsByCorreo(correo)) {
    		String encodedEmail =Base64.getEncoder().encodeToString(correo.getBytes());
    		String codigo=generarCodigo(correo);
    		String token= codigo+"-"+encodedEmail;
    		Verificacion verificacion = Verificacion.builder()
    				.email(correo)
    				.codigo(codigo)
    				.expiracion(Date.from(Instant.now().plus(10, ChronoUnit.MINUTES)))
    				.tipo(TipoVerification.clave)
    				.build();
    		if(verificacionRepository.existsByEmailAndTipo(correo,TipoVerification.clave)) {
    			verificacion.setId(verificacionRepository
    					.getidOfVerificacionType(correo, TipoVerification.clave.toString()));
    		}
    		verificacionRepository.save(verificacion);
    		

    		try {
    			client.restablecerClave(correo,token).getBody();
			} catch (Exception e) {
				if(e.getCause().getClass()==java.net.SocketTimeoutException.class) {
					return "Enviado";
				}
				else {
	    			return "NoEnviado";
	    		}
			}
    		
    	}
		return "NoRegistrado";
	   }
	 
	
    private String generarCodigo(String email) {
		String sha256hex = Hashing.sha512()
				  .hashString(email+new Date().toString(), StandardCharsets.UTF_8)
				  .toString();
		return sha256hex;
		
	}
    
	private boolean isvalidToken(Date date ){
		return date.after(new Date());
	}

}
