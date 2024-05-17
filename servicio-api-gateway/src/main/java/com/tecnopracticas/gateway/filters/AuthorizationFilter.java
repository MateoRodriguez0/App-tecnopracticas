package com.tecnopracticas.gateway.filters;


import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import com.tecnopracticas.gateway.errors.NoTokenHeaderException;
import com.tecnopracticas.gateway.security.jwtServices;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.AllArgsConstructor;
import lombok.Data;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
@Data
public class AuthorizationFilter implements WebFilter{
	private jwtServices jwtProvider; 
	private List<String> paths;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();  
		if (request.getMethod() == HttpMethod.OPTIONS) {
	        return chain.filter(exchange); // Allow OPTIONS requests without token
	    }
		  String path=request.getPath().value();
		  for (String p : paths) {
			if(p.equals(path))
				return chain.filter(exchange);
		}
	      
	      if(request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
	    	  String auth=request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
	
	    	  if(auth.startsWith("Bearer ")) {
	    		  String token=auth.split(" ")[1];
	    		  try {
	    			  if(jwtProvider.isTokenValid(token)) {
	    				  exchange.getAttributes().put("token", token);
	    				  return chain.filter(exchange);
	    			  }else {
	    				  return Mono.error(new MalformedJwtException("InvalidToken"));
	    			  }
	    			} catch (ExpiredJwtException e) {
	    				 return Mono.error(new ExpiredJwtException(null,null,"ExpiredToken")); 	
	    			}
	    			 catch (MalformedJwtException  e) {
	    				 return Mono.error(new MalformedJwtException("InvalidToken"));
	    			}
	    		  	catch ( SignatureException e) {
	    				 return Mono.error(new SignatureException("InvalidToken"));
	    			}
	        	}
	        }
	      return Mono.error(new NoTokenHeaderException("TokenNotFound"));      	
	}
}
