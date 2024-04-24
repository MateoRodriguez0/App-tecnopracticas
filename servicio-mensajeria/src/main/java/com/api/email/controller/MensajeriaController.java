package com.api.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.email.models.entity.Postulacion;
import com.api.email.models.entity.VerificationCode;
import com.api.email.repository.VerificationCodeRepository;
import com.api.email.services.AccountService;
import com.api.email.services.PostulacionesService;

import jakarta.mail.MessagingException;

@RestController
public class MensajeriaController {

	
	@PostMapping("/create-account")
	public  ResponseEntity<Boolean>  enviarCorreo(@RequestParam("email") String email,
			@RequestParam("token") String token){
		if(accountService.EnviarCodigo(email,token)) {
			
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.ok(false);
	}
	
	@GetMapping(value = "/verifications")
	public List<VerificationCode>  getverifications(){
		return codeRepository.findAll();
	}
	
	
	@GetMapping(value ="/verifier-account")
	public ResponseEntity<Boolean> verifierCode(@RequestParam String email) {
		if(accountService.CuentaAprobada(email)) {
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.ok(false);
	}
	
	
	@GetMapping(value = "/restore-pasword")
	public ResponseEntity<Boolean> restorePasword(@RequestParam(name = "email")String email) 
			throws MailException, MessagingException{
			
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/restored-pasword")
	public ResponseEntity<Boolean> restoredPasword(@RequestParam(name = "email")String email) 
			throws MailException, MessagingException{
			
		return ResponseEntity.noContent().build();
	}
	
	
	@PostMapping(value = "/postulaciones/rechazada")
	public ResponseEntity<Boolean> postulacionRechazada(@RequestBody Postulacion postulacion) 
			throws MailException, MessagingException{
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/postulaciones/aprobada")
	public ResponseEntity<Boolean> postulacionAprobada(@RequestBody Postulacion postulacion) 
			throws MailException, MessagingException{
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/postulaciones/creada")
	public ResponseEntity<Boolean> PostulacionCreada(@RequestBody Postulacion postulacion) 
			throws MailException, MessagingException{
		return ResponseEntity.ok(postulaciones.PostulacionRealizada(postulacion));
	}
	
	@GetMapping(value = "/ofertas/creada/")
	public ResponseEntity<Boolean> ofertaCreada() 
			throws MailException, MessagingException{
		
		return ResponseEntity.noContent().build();
	}
	
	
	@Autowired
	private PostulacionesService postulaciones;
	@Autowired
	private VerificationCodeRepository codeRepository;
	@Autowired
	private AccountService accountService;
	
}
