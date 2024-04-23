package com.api.email.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.api.email.models.entity.VerificationCode;
import com.api.email.repository.UsuariosRespository;
import com.api.email.repository.VerificationCodeRepository;

import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;

@Service
@Scope("prototype")
public class AccountService {

	public boolean CuentaAprobada(String email) {
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
	
	
	public Boolean EnviarCodigo (String email, String token){
		try {
			String url= urlVerificacion+"?token="+token;
			emailServices.enviarCorreo(email,"verifica tu cuenta de TecnoPracticas", 
				plantillasService.getCorreoVerificarCuenta(
						usuariosRespository.getnombreByEmail(email),url));
			return true;
		} catch (MailException|MessagingException e) {
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
