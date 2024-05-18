package com.tecnopracticas.gateway.security;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.tecnopracticas.gateway.models.InfoToken;
import com.tecnopracticas.gateway.models.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import reactor.core.publisher.Mono;

@Component
@Data
public class jwtServices{
	
	public Key generarkey() {
		byte[] encodedSecretKey = Base64.getDecoder().decode(this.key);
		return Keys.hmacShaKeyFor(encodedSecretKey);
	}

	
	public String ExtractUsername(String jwt) {
		// TODO Auto-generated method stub
		return extractClaims(jwt).getSubject();
	}

	
	public String generarToken(Usuario userDetails) {
		// TODO Auto-generated method stub
		Map<String, Object> claims=new HashMap<>();
		Usuario usuario= (Usuario) userDetails;
		claims.put("id", usuario.getId());
		claims.put("authorities",userDetails.getRoles()
				.stream()
				.map(g -> g.getNombre()).toList());
				
		String jwt=Jwts.builder()
				.issuer("TecnoPracticas")
				.subject(userDetails.getCorreo())
				.claim("token_type", "authorization_code")
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+(minutosExpiracion*60*1000)))
				.header().add("typ", "JWT")
				.and()
				.signWith(generarkey())
				.claims(claims).compact();
		return jwt;
	}

	
	public String generateRefreshToken(Usuario usuario){
		 Map<String, Object> claims=new HashMap<>();
			claims.put("authorities",usuario.getRoles()
					.stream()
					.map(g -> g.getNombre()).toList());
	        return Jwts.builder()
	                .subject(usuario.getCorreo())
	                .claim("token_type", "refresh_token")
	                .issuer("TecnoPracticas")
	                .issuedAt(new Date(System.currentTimeMillis()))
	                .expiration(new Date(System.currentTimeMillis() 
	                		+(minutosExpiracionRefreshToken*60*1000)))
	                .signWith(generarkey())
	                .claims(claims).compact();
	    }

	
	public boolean isTokenValid(String token) {
		if(!extractClaims(token).get("token_type", String.class).equals("authorization_code")) {
			return false;
		}
		return true;
	
	}

	
	public boolean isTokenExpired(String token) {
		return extractClaims(token).getExpiration().before(new Date());
	}
	
	
	public Mono<Boolean> isRefreshTokenValid(String token) {
		if(!extractClaims(token).get("token_type", String.class).equals("refresh_token")) {
			throw new JwtException(null);
		}
		String username = ExtractUsername(token);
		return WebClient.create().get()
		           .uri("http://localhost:10451/buscar?email="+username)
		           .retrieve()
		           .bodyToMono(Usuario.class)
		           .flatMap(u ->{
		        	   return Mono.just(u.isEnabled() && !isTokenExpired(token));
		           });
	}
	
	
	public InfoToken getInfoToken(String token) {
		Claims claims=extractClaims(token);
		InfoToken infoToken= InfoToken.builder()
				.id(UUID.fromString(claims.get("id").toString()))
				.build();
		String authorities=claims.get("authorities").toString().replaceAll("^\\[|\\]", "");
		if(authorities.contains(",")) {
			List<String> roles= List.of(authorities.split(","));
			infoToken.setRoles(roles);
		}
		else {
			List<String> roles= List.of(authorities);
			infoToken.setRoles(roles);
		}

		
		return infoToken;
	}

	
	
	public Claims extractClaims(String jwt) {
		// TODO Auto-generated method stub
		return Jwts.parser()
				.verifyWith((SecretKey) generarkey())
				.build()
				.parseSignedClaims(jwt)
				.getPayload();
	}

	@Value("${security.jwt.key}")
	String key;
	
	@Value("${security.jwt.expiration.token}")
	private Integer minutosExpiracion;
	
	@Value("${security.jwt.expiration.refresh-token}")
	private Integer minutosExpiracionRefreshToken;

}
