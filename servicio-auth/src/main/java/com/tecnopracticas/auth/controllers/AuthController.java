package com.tecnopracticas.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecnopracticas.auth.models.AuthenticationRequest;
import com.tecnopracticas.auth.models.AuthenticationResponse;
import com.tecnopracticas.auth.services.AuthenticationService;
import com.tecnopracticas.auth.services.JwtServices;
import com.tecnopracticas.auth.services.ResponsesServices;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;

@RestController
public class AuthController {
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> authentication(
			@RequestBody AuthenticationRequest authenticationRequest){
		try {
			return ResponseEntity.ok(authenticationService.login(authenticationRequest));
		} catch (DisabledException e) {
			return responsesServices.DisabledException();
		}catch (BadCredentialsException e) {
			return responsesServices.BadCredentialsException();
		}
	}
	
	@PostMapping(value = "/refresh")
	public ResponseEntity<?> authentication(
			@RequestBody AuthenticationResponse response){
		try {
			return ResponseEntity.ok(authenticationService.refreshToken(response));
		} catch (ExpiredJwtException  e) {
			return responsesServices.ExpiredToken();
		}catch (JwtException e) {
			return responsesServices.InvalidToken();
		}
		
	}
	
	@GetMapping(value = "/validate")
	public ResponseEntity<?> validar(@RequestParam String token){
		try {
			return ResponseEntity.ok(jwtServices.isTokenValid(token));
		} catch (JwtException e) {
			return ResponseEntity.ok(false);
		}
	}
	
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private JwtServices jwtServices;
	
	@Autowired
	private ResponsesServices responsesServices;
}
