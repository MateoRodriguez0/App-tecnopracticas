package com.api.email.services;

import java.util.Date;
import java.util.UUID;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.api.email.models.entity.TipoVerification;
import com.api.email.models.entity.VerificationCode;
import com.api.email.repository.UsuariosRespository;
import com.api.email.repository.VerificationCodeRepository;
import com.google.common.hash.Hashing;

import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;

@Service
@Scope("prototype")
public class AccountService {

	public boolean validarCuenta(UUID userId,  String token) {
		VerificationCode verificationCode= codeRepository.getByUserIdAndCode(userId, token);
		if(verificationCode ==null) {
			return false;
		}
		if(!validateExpirationCode(verificationCode.getExpiracion())) {
			return false;
		}
		
		return cuentaExitosa(verificationCode.getEmail());
		
	}
	
	
	public Boolean EnviarCodigo (String email){
		Date expiration = Date.from(Instant.now().plus(15, ChronoUnit.MINUTES));
		String codigo=generarCodigo(email);
		VerificationCode verificationCode = VerificationCode.builder()
				.email(email).codigo(codigo)
				.expiracion(expiration)
				.tipo(TipoVerification.cuenta)
				.build();
		
		if(codeRepository.existsByEmail(email)) {
			verificationCode =codeRepository.findByEmail(email);
			verificationCode.setCodigo(codigo);
			verificationCode.setExpiracion(expiration);
			
		}

		
		try {
			String url= urlVerificacion+"?token="+codigo+"&user="+codeRepository.getidOfUserByEmail(email);
			codeRepository.save(verificationCode);
			emailServices.enviarCorreo(email,"verifica tu cuenta de TecnoPracticas", 
				plantillasService.getCorreoVerificarCuenta(
						usuariosRespository.getnombreByEmail(verificationCode.getEmail()),url));
			return true;
		} catch (MailException|MessagingException e) {
			
		}
		return false;
	}
	
	

	
	private String generarCodigo(String email) {
		String sha256hex = Hashing.sha512()
				  .hashString(email, StandardCharsets.UTF_8)
				  .toString();
	    return sha256hex;
		
	    
	}
	
	private boolean cuentaExitosa(String email) {
		String cuerpo= plantillasService
				.getCorreoCuentaVerificada(usuariosRespository.getnombreByEmail(email));
		try {
			emailServices.enviarCorreo(email, "Cuenta de TecnoPracticas aprobada", cuerpo);
			return true;
		} catch (MailException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public void deleteVerificationCode(String email) {
		 VerificationCode verificationCode = codeRepository.findByEmail(email);
		  if (verificationCode != null) {
		   codeRepository.delete(verificationCode);
		  }
	}
	
	
	private Boolean validateExpirationCode(Date expiration) {
		
		return expiration.after(new Date());
		
	}
	

	public boolean SeCambioLaClave(String email) {
		String cuerpo= plantillasService
				.getCorreoClaveCambiada(usuariosRespository.getnombreByEmail(email));
		try {
			emailServices.enviarCorreo(email, "Cambio de contraseña", cuerpo);
			return true;
		} catch (MailException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean RestablecerClave(String email) {
		String cuerpo= plantillasService
				.getCorreoRestablecerClave(usuariosRespository.getnombreByEmail(email));
		try {
			emailServices.enviarCorreo(email, "Restablece tu contraseña de tecnopracticas", cuerpo);
			return true;
		} catch (MailException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Autowired
	private EmailServices emailServices;
	
	@Autowired
	private PlantillasService plantillasService;
	
	@Autowired
	private UsuariosRespository usuariosRespository;
	
	@Autowired
	private VerificationCodeRepository codeRepository;	
	
	
	@Value("${tecnopracticas.urls.verificacion}")
	private String urlVerificacion;
}
