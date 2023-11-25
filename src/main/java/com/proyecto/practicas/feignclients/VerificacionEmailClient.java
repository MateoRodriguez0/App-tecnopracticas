package com.proyecto.practicas.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.practicas.models.VerificationCode;

@FeignClient( name = "email",url = "http://localhost:9050")
public interface VerificacionEmailClient {


	@PostMapping("/mail/enviar")
	public  ResponseEntity<?>  enviarCorreo(@RequestParam("email") String email);
	
	@PostMapping(value ="/mail/verifier")
	public ResponseEntity<Boolean> verifierCode(@RequestBody VerificationCode verificationCode);
	
	
	@GetMapping(value = "/mail/account-created")
	public ResponseEntity<Boolean> accountCreated(@RequestParam(name = "email")String email);
}
