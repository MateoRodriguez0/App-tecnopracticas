package com.tecnopracticas.auth.services;

import java.security.Key;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface JwtServices {

	Key generarkey();

	/**
	 * extrae el subject del JWT.  
	 * 
	 * @param jwt es el token codificado en base64.
	 * @return
	 */
	String ExtractUsername(String jwt);
	
	/**
	 * Crea un JWT a partir de los parametros, establece el parametro claims como parte del playload 
	 * y utiliza un userdetails para obtener username y settear el subject del JWT.
	 * 
	 * @param userDetails Es el usuario autenticado.
	 * @param claims Es un map que contiene algunas claves y valores que rian en el JWT.
	 * @return Devuele un String que contiene el JWT.
	 */
	String generarToken(UserDetails userDetails);
	
	/**
	 * extrae el Claims de un token con el proposito de poder proveer 
	 * el claims al metodo ExtracUsername(String jwt) de esta interfaz.
	 * 
	 * @param jwt es el token codificado con base64.
	 * @return Devuelve los claims del token.
	 */
	Claims extractClaims(String jwt);
	
	public String isTokenValid(String token);
	
	public boolean isRefreshTokenValid(String token);
	    
	public boolean isTokenExpired(String token);

	String generateRefreshToken(UserDetails userDetails);
	
	
	
}
