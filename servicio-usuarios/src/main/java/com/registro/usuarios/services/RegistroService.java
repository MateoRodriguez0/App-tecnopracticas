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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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

 
    public String registarUsuario(Usuario usuario) throws Exception {
    	ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
    	
    	CompletableFuture<String>futureCodigo=CompletableFuture.supplyAsync(()->
    		generarCodigo(usuario.getCorreo()), service);
    	
    	CompletableFuture<String>encodedEmail=CompletableFuture.supplyAsync(() ->
    		Base64.getEncoder().encodeToString(usuario.getCorreo().getBytes()), service);
    	
		
    	if(!usuarioRepository.existsByCorreo(usuario.getCorreo())) {
    		CompletableFuture<Void> insertarUsuario = CompletableFuture.runAsync(() ->
    		usuarioRepository.save(usuarioRegistroNuevo(usuario)), service);
    		insertarUsuario.join(); 
    		String token= futureCodigo.get()+"-"+encodedEmail.get();
    	
    		CompletableFuture<Verificacion> futureVerificacion=CompletableFuture.supplyAsync(() -> {
    			try {
					return Verificacion.builder()
							.email(usuario.getCorreo())
							.codigo(futureCodigo.get())
							.expiracion(Date.from(Instant.now().plus(10, ChronoUnit.MINUTES)))
							.tipo(TipoVerification.cuenta)
							.build();
				} catch (Exception e) {
					return null;
				} 
    		}, service);
    		
    		verificacionRepository.save(futureVerificacion.get());
    		try {
        		 client.VerificarCuenta(usuario.getCorreo(),token).getBody();
        		}catch (feign.RetryableException e) {
        			if(e.getCause().getClass()==java.net.SocketTimeoutException.class) {
        				return "Cuenta registrada, correo de verificacion enviado.";
         			};
         			
        			return "Cuenta registrada, correo de verificacion No enviado.";
    			}
     		
     		return "Cuenta registrada, correo de verificacion No se pudo enviar.";
    	}
    	
    	if(usuarioRepository.existsByCorreo(usuario.getCorreo())&& 
    			! usuarioRepository.correoVerificado(usuario.getCorreo())) {
    		boolean tokenValido=isvalidToken(verificacionRepository.getExpirationByEmail(usuario.getCorreo(),
					TipoVerification.cuenta.toString()));
    		
    		Verificacion verificacion = verificacionRepository
    				.findByEmailAndTipo(usuario.getCorreo(), TipoVerification.cuenta.toString());
    		if(!tokenValido) {
    			CompletableFuture.runAsync(() ->
    				usuarioRepository.save(usuarioRegistroExistente(usuario)) , service);
    		
    			
    			CompletableFuture.runAsync(() ->{
    				verificacion.setExpiracion(Date.from(Instant.now().plus(10, ChronoUnit.MINUTES)));
        			try {
						verificacion.setCodigo(futureCodigo.get());
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
        			verificacionRepository.save(verificacion);
    			}, service);
    		
    			try {
    				 String token=futureCodigo.get()+"-"+encodedEmail;
            		 client.VerificarCuenta(usuario.getCorreo(),token).getBody();
            		}catch (feign.RetryableException e) {
            			if(e.getCause().getClass()==java.net.SocketTimeoutException.class) {
            				return "Cuenta registrada, correo de verificacion enviado.";
             			};
             			
            			return "Cuenta registrada, correo de verificacion No enviado.";
        			}
    		}
    		return "La cuenta ya se encuentra registrada, falta la verificacion de correo";
    	}		
    	return "El correo electronico ya se encuentra registrado.";	
    }


    @Transactional
    public String verificarCuenta(String token) {
    	if(!token.matches("([a-z0-9]+)-([a-zA-Z0-9]+)==")) {
    		return "token invalido";
    	}
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
            			usuarioRepository.habilitarUsuario(email);
            			try {
            				client.cuentaVerificada(email);
						} catch (Exception e) {
							if(e.getCause().getClass()==java.net.SocketTimeoutException.class) {}
						}
            			
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
    
	private Usuario usuarioRegistroNuevo(Usuario usuario){
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setFecha_registro(Timestamp.from(Instant.now()));
		usuario.setVerificado(false);
		usuario.setActivo(false);
		usuario.setRoles(List.of(rolesRepository.findByNombre("ESTUDIANTE")));
		return usuario;
	}
	
	private Usuario usuarioRegistroExistente(Usuario usuario){
		usuario.setId(usuarioRepository.getIdByCorreo(usuario.getCorreo()));
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setVerificado(false);
		usuario.setRoles(List.of(rolesRepository.findByNombre("ESTUDIANTE")));
		usuario.setActivo(false);
		return usuario;
	}
    
    private String generarCodigo(String email) {
		String sha256hex = Hashing.sha512()
				  .hashString(email+new Date().toString(), StandardCharsets.UTF_8)
				  .toString();
		return sha256hex;
		
	}
    
    
   
}
