package com.tecnopracticas.auth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecnopracticas.auth.models.Usuario;

@FeignClient(name = "AuthClient",url = "http://localhost:10451")
public interface UsuarioClient {

	@GetMapping(value="/buscar")
	public ResponseEntity<Usuario> buscar(@RequestParam String email);
	
}
