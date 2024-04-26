package com.tecnopracticas.gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class RouteTecnopracticas {

	@Bean
	RouteLocator routesTecnopracticas(RouteLocatorBuilder builder) {
	
		return builder.routes()
				.route("servicio-usuarios",p ->
					p.path("/usuarios/**")
					.and()
					.predicate(s ->{
						return !s.getRequest().getURI()
								.getPath().toString().equals("/usuarios/buscar");
					})
					.and()
					.method(HttpMethod.GET,HttpMethod.POST)
					.filters(f ->f.stripPrefix(1) )
					.uri("http://localhost:10451"))
				.route("servicio-auth",p ->
					p.path("/auth/**")
					.and()
					.method(HttpMethod.POST)
					.filters(f ->f.stripPrefix(1))
					.uri("http://localhost:10453"))
				.build();
	}
	

	
}
