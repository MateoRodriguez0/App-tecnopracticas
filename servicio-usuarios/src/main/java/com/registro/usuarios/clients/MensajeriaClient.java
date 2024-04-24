package com.registro.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "mensajeriaClient",url = "http://localhost:10455")
public interface MensajeriaClient {

	@PostMapping("/create-account")
	public  ResponseEntity<Boolean>  VerificarCuenta(@RequestParam("email") String email,
			@RequestParam("token") String token);
	
	@GetMapping(value ="/verifier-account")
	public ResponseEntity<Boolean> cuentaVerificada(@RequestParam String email);
	
	@GetMapping(value = "/restore-pasword")
	public ResponseEntity<Boolean> restaurarClave(@RequestParam(name = "email")String email,
			@RequestParam("token") String token);
	
	@GetMapping(value = "/restored-pasword")
	public ResponseEntity<Boolean> claveRestaurada(@RequestParam(name = "email")String email); 
	
}
