package com.api.email.controller;

import java.util.List;
import java.util.UUID;

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
	public  ResponseEntity<?>  enviarCorreo(@RequestParam("email") String email) throws MessagingException{
		
		if(accountService.EnviarCodigo(email)) {
			return ResponseEntity.ok(true);
		}
		
		return ResponseEntity.ok(false);
	}
	
	@GetMapping(value = "/verifications")
	public List<VerificationCode>  getverifications(){
		
		return codeRepository.findAll();
	}
	
	
	@GetMapping(value ="/verifier-account")
	public ResponseEntity<?> verifierCode(@RequestParam String token,@RequestParam UUID user ) {
		if(accountService.validarCuenta(user, token)) {
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.ok(false);
	}
	
	
	@GetMapping(value = "/resset-pasword")
	public ResponseEntity<?> ressetPasword(@RequestParam(name = "email")String email) 
			throws MailException, MessagingException{
			
		return ResponseEntity.noContent().build();
	}
	
	
	@PostMapping(value = "/postulaciones/rechazada")
	public ResponseEntity<?> postulacionRechazada(@RequestBody Postulacion postulacion) 
			throws MailException, MessagingException{
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/postulaciones/aprobada")
	public ResponseEntity<?> postulacionAprobada(@RequestBody Postulacion postulacion) 
			throws MailException, MessagingException{
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/postulaciones/creada")
	public ResponseEntity<?> PostulacionCreada(@RequestBody Postulacion postulacion) 
			throws MailException, MessagingException{
		return ResponseEntity.ok(postulaciones.PostulacionRealizada(postulacion));
	}
	
	@GetMapping(value = "/ofertas/creada/")
	public ResponseEntity<?> ofertaCreada() 
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
