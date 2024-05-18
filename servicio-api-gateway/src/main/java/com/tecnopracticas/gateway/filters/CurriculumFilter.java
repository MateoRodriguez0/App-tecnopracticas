package com.tecnopracticas.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import  com.tecnopracticas.gateway.security.jwtServices;
import reactor.core.publisher.Mono;

@Component
public class CurriculumFilter implements GatewayFilter {
	private  jwtServices jwtServices;
	
	public CurriculumFilter(jwtServices jwtServices) {
		super();
		this.jwtServices = jwtServices;
	}

	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
	    String token = exchange.getRequest().getHeaders().getFirst("Authorization").split(" ")[1];
	    String path=exchange.getRequest().getPath().value();
	    if(path.equals("/curriculum/me")| path.equals("/usuarios/info-me")
	    							||path.equals("/curriculum/guardar")) {
	    	 String id = jwtServices.getInfoToken(token).getId().toString();
	         ServerHttpRequest request = exchange.getRequest().mutate().header("id", id).build();
	         exchange.mutate().request(request).build();
	    }
	   
	    return chain.filter(exchange);
	    
        
	    
	}

	

}
