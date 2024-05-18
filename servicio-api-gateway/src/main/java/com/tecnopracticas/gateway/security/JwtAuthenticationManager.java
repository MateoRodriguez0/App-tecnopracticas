package com.tecnopracticas.gateway.security;


import java.util.List;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationManager implements ReactiveAuthenticationManager {

	private final jwtServices jwtProvider;  
	  
    public JwtAuthenticationManager(jwtServices jwtProvider) {  
        this.jwtProvider = jwtProvider;  
    } 
	@Override
	public Mono<Authentication> authenticate(Authentication authentication) {

		 return Mono.just(authentication)
	                .map(auth -> jwtProvider.extractClaims(auth.getCredentials().toString()))
	                .log()
	                .onErrorResume(e -> Mono.error(new Throwable("bad token")))
	                .map(claims -> {
	                	String authorities=claims.get("authorities").toString().replaceAll("^\\[|\\]", "");
	                	List<String> roles=null;
	           
	                	if(authorities.contains(",")) {
	            			roles= List.of(authorities.split(","));
	            			
	            		}
	            		else {
	            			roles= List.of(authorities);
	            			
	            		}
	            		return new UsernamePasswordAuthenticationToken(claims.getSubject(),
	            				null,roles.stream()
	            				.map(rol ->new SimpleGrantedAuthority(rol)).toList());
	                }
	                );
	}
}
