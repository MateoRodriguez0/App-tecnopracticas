package com.tecnopracticas.auth.services.implementations;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.tecnopracticas.auth.clients.UsuarioClient;
import com.tecnopracticas.auth.models.Usuario;
import com.tecnopracticas.auth.services.JwtServices;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
@Scope("prototype")
public class JwtServicesImpl implements JwtServices{

	@Override
	public Key generarkey() {
		byte[] encodedSecretKey = Base64.getDecoder().decode(this.key);
		return Keys.hmacShaKeyFor(encodedSecretKey);
	}

	@Override
	public String ExtractUsername(String jwt) {
	
		// TODO Auto-generated method stub
		return extractClaims(jwt).getSubject();
	}

	@Override
	public String generarToken(UserDetails userDetails) {
		// TODO Auto-generated method stub
		Map<String, Object> claims=new HashMap<>();
		claims.put("authorities",userDetails.getAuthorities()
				.stream()
				.map(g -> g.getAuthority()).toList());
				
		String jwt=Jwts.builder()
				.issuer("TecnoPracticas")
				.subject(userDetails.getUsername())
				.claim("token_type", "authorization_code")
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+(minutosExpiracion*60*1000)))
				.header().add("typ", "JWT")
				.and()
				.signWith(generarkey())
				.claims(claims).compact();
		return jwt;
	}

	@Override
	public String generateRefreshToken(UserDetails userDetails){
		 Map<String, Object> claims=new HashMap<>();
			claims.put("authorities",userDetails.getAuthorities()
					.stream()
					.map(g -> g.getAuthority()).toList());
	        return Jwts.builder()
	                .subject(userDetails.getUsername())
	                .claim("token_type", "refresh_token")
	                .issuer("TecnoPracticas")
	                .issuedAt(new Date(System.currentTimeMillis()))
	                .expiration(new Date(System.currentTimeMillis() 
	                		+(minutosExpiracionRefreshToken*60*1000)))
	                .signWith(generarkey())
	                .claims(claims).compact();
	    }

	@Override
	public String isTokenValid(String token) {
		if(!extractClaims(token).get("token_type", String.class).equals("authorization_code")) {
			throw new JwtException(null);
		}
	
	    String username = ExtractUsername(token);
	    Usuario usuario =client.buscar(username).getBody();
        return usuario.getRoles().stream().map(r ->r.getNombre()).reduce((t, u) ->t+","+u).get();
	}

	@Override
	public boolean isTokenExpired(String token) {
		return extractClaims(token).getExpiration().before(new Date());
	}
	
	@Override
	public boolean isRefreshTokenValid(String token) {
		if(!extractClaims(token).get("token_type", String.class).equals("refresh_token")) {
			throw new JwtException(null);
		}
		String username = ExtractUsername(token);
		Usuario usuario =client.buscar(username).getBody();
		return (usuario.isEnabled() && !isTokenExpired(token));
	}
	
	
	@Override
	public Claims extractClaims(String jwt) {
		// TODO Auto-generated method stub
		return Jwts.parser()
				.verifyWith((SecretKey) generarkey())
				.build()
				.parseSignedClaims(jwt)
				.getPayload();
	}

	@Value("${security.jwt.key}")
	private String key;
	
	@Value("${security.jwt.expiration.token}")
	private Integer minutosExpiracion;
	
	@Value("${security.jwt.expiration.refresh-token}")
	private Integer minutosExpiracionRefreshToken;


	
	@Autowired
	private UsuarioClient client;




}
