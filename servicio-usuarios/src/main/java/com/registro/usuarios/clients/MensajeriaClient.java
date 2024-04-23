package com.registro.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "mensajeriaClient",url = "http://localhost:10455")
public interface MensajeriaClient {

	@PostMapping("/create-account")
	public  ResponseEntity<?>  enviarCorreo(@RequestParam("email") String email);
	
	@GetMapping(value ="/verifier-account")
	public ResponseEntity<?> verifierCode(String email);
	
	@GetMapping(value = "/restore-pasword")
	public ResponseEntity<?> restorePasword(@RequestParam(name = "email")String email);
	
	@GetMapping(value = "/restored-pasword")
	public ResponseEntity<?> restoredPasword(@RequestParam(name = "email")String email); 
	
}
