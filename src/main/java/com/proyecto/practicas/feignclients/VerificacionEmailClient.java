package com.proyecto.practicas.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.practicas.models.VerificationCode;

@FeignClient(url = "http://localhost:8080")
public interface VerificacionEmailClient {


	@PostMapping("/mail/enviar")
	public  ResponseEntity<?>  enviarCorreo(@RequestParam("email") String email);
	
	@PostMapping(value ="/verifier")
	public ResponseEntity<?> verifierCode(@RequestBody VerificationCode verificationCode);
	
	
	@GetMapping(value = "/account-created")
	public ResponseEntity<?> accountCreated(@RequestParam(name = "email")String email);
}
