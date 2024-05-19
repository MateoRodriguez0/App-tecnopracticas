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
	
	
	@GetMapping(value = "/password-reset")
	public ResponseEntity<Boolean> restorePasword(@RequestParam(name = "email")String email,
			@RequestParam(name = "token") String token){
		if(accountService.RestablecerClave(email, token)) {
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.ok(false);
	}
	
	@GetMapping(value = "/password-restored")
	public ResponseEntity<Boolean> restoredPasword(@RequestParam(name = "email")String email) 
			throws MailException, MessagingException{
		if(accountService.SeCambioLaClave(email)) {
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.ok(false);
	}

	@PostMapping(value = "/postulaciones/rechazada")
	public ResponseEntity<Boolean> postulacionRechazada(@RequestBody Postulacion postulacion) {
		return ResponseEntity.ok(postulaciones.PostulacionRechazada(postulacion));
	}
	
	@PostMapping(value = "/postulaciones/aprobada")
	public ResponseEntity<Boolean> postulacionAprobada(@RequestBody Postulacion postulacion){
		return ResponseEntity.ok(postulaciones.PostulacionAprobada(postulacion));
	}
	
	@PostMapping(value = "/postulaciones/creada")
	public ResponseEntity<Boolean> PostulacionCreada(@RequestBody Postulacion postulacion){
		return ResponseEntity.ok(postulaciones.PostulacionRealizada(postulacion));
	}
	
	@PostMapping(value = "/postulaciones/revision")
	public ResponseEntity<Boolean> PostulacionEnRevision(@RequestBody Postulacion postulacion){
		return ResponseEntity.ok(postulaciones.PostulacionEnRevision(postulacion));
	}
	
	
	@Autowired
	private PostulacionesService postulaciones;
	@Autowired
	private VerificationCodeRepository codeRepository;
	@Autowired
	private AccountService accountService;
	
}
