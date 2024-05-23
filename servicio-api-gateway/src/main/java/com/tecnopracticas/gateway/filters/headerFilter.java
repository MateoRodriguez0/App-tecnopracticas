package com.tecnopracticas.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import  com.tecnopracticas.gateway.security.jwtServices;
import reactor.core.publisher.Mono;

@Component
public class headerFilter implements GatewayFilter {
	private  jwtServices jwtServices;
	
	public headerFilter(jwtServices jwtServices) {
		super();
		this.jwtServices = jwtServices;
	}

	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
	    String path=exchange.getRequest().getPath().value();
	    if(path.startsWith("/curriculum")|| path.equals("/info-me")
	    		    ||path.startsWith("/postulaciones")
	    			||path.startsWith("/carreras/")||path.startsWith("/ofertas")
	    			||path.startsWith("/empresas")||path.startsWith("/facultades")) {
	    	 String token = exchange.getRequest().getHeaders().getFirst("Authorization").split(" ")[1];
	    	 String id = jwtServices.getInfoToken(token).getId().toString();
	         ServerHttpRequest request = exchange.getRequest().mutate().header("id", id).build();
	         exchange.mutate().request(request).build();
	    }
	   
	    return chain.filter(exchange);
	    
        
	    
	}

	

}
