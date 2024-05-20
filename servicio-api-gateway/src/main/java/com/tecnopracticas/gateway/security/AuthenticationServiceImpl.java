package com.tecnopracticas.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tecnopracticas.gateway.models.AuthenticationRequest;
import com.tecnopracticas.gateway.models.AuthenticationResponse;
import com.tecnopracticas.gateway.models.Usuario;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;


@Component
@AllArgsConstructor
public class AuthenticationServiceImpl {

	@Autowired
	private ResponsesServices responsesServices;
	
	public Mono<ServerResponse> loginHandler(ServerRequest request) {
	    return request.bodyToMono(AuthenticationRequest.class)
	            .flatMap(auth -> this.login(auth))
	            .flatMap(response -> ServerResponse.ok()
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .bodyValue(response))
	            .onErrorResume(BadCredentialsException.class, e ->
	                    ServerResponse.status(HttpStatus.OK).bodyValue(responsesServices.BadCredentialsException()))
	            .onErrorResume(DisabledException.class, e -> // Handle other exceptions
	                    ServerResponse.status(HttpStatus.OK).bodyValue(responsesServices.DisabledException()));
		
	
	}
	
	public Mono<ServerResponse> refreshTokenHandler(ServerRequest request) {
		return request.bodyToMono(AuthenticationResponse.class)
				.flatMap(auth -> this.refreshToken(auth))
				.flatMap(response -> ServerResponse.ok()
			              .contentType(MediaType.APPLICATION_JSON)
			              .bodyValue(response))
				.onErrorResume(ExpiredJwtException.class, e ->
                ServerResponse.status(HttpStatus.OK).bodyValue(responsesServices.ExpiredToken()))
				.onErrorResume(JwtException.class, e -> // Handle other exceptions
                ServerResponse.status(HttpStatus.OK).bodyValue(responsesServices.InvalidToken()));
		
		
	}
	

	public Mono<AuthenticationResponse> login(AuthenticationRequest request) {
	    return WebClient.create().get()
	            .uri("http://localhost:10451/buscar?email=" + request.getUsername())
	            .retrieve()
	            .bodyToMono(Usuario.class)
	            .flatMap(usuario -> {
	                if (passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
	                	if(!usuario.isActivo()) {
		                    return Mono.error(new DisabledException(""));
		                }
	                    String jwt = jwtServices.generarToken(usuario);
	                    String refreshToken = jwtServices.generateRefreshToken(usuario);
	                    return Mono.just(AuthenticationResponse.builder()
	                            .token(jwt)
	                            .user_id(usuario.getId())
	                            .refreshToken(refreshToken)
	                            .expires_in(60 * 20)
	                            .scope(usuario.getRoles().stream().map(r -> r.getNombre()).findFirst().get().substring(0,2))
	                            .build());
	                } 
	       
	                else {
	                    return Mono.error(new BadCredentialsException(""));
	                }
	            });
	}


	public Mono<AuthenticationResponse> refreshToken(AuthenticationResponse token) {
		return jwtServices.isRefreshTokenValid(token.getToken())
			.flatMap(valid ->{
				if(valid) {
					 return WebClient.create().get()
					            .uri("http://localhost:10451/buscar?email="+jwtServices.ExtractUsername(token.getToken()))
					            .retrieve()
					            .bodyToMono(Usuario.class)
					            .flatMap(usuario ->{
					            	String jwt=jwtServices.generarToken(usuario);
					    			String refresToken=jwtServices.generateRefreshToken(usuario);
					    			return Mono.just(AuthenticationResponse.builder()
					    					.token(jwt)
					    					.user_id(usuario.getId())
					    					.refreshToken(refresToken)
					    					.expires_in(60*20)
					    					.build());	
					            });
				}
				return Mono.error(new JwtException(""));	
			});
		
	}
	
	private jwtServices jwtServices;

	private PasswordEncoder passwordEncoder;
}
