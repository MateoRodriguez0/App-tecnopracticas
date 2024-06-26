package com.tecnopracticas.gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.tecnopracticas.gateway.filters.headerFilter;
import com.tecnopracticas.gateway.security.AuthenticationServiceImpl;
import com.tecnopracticas.gateway.security.jwtServices;

@Configuration
public class RouteTecnopracticas {

	
	@Bean
	RouteLocator routesTecnopracticas(RouteLocatorBuilder builder, jwtServices jwtServices) {
	
		return builder.routes()
				.route("servicio-usuarios",p ->
					p.path("/usuarios/**")
					.and()
					.predicate(s ->{
						return !s.getRequest().getURI()
								.getPath().toString().equals("/usuarios/buscar");
					})
					.and()
					.method(HttpMethod.GET,HttpMethod.POST,HttpMethod.PUT, HttpMethod.OPTIONS)
					.filters(f ->
						f.stripPrefix(1)
						.filter(new headerFilter(jwtServices)))
					.uri("http://localhost:10451"))
				.route("informacion",p ->
				p.path("/usuarios/info-me")
				.and()
				.method(HttpMethod.GET)
				.filters(f ->
					f.stripPrefix(1)
					.filter(new headerFilter(jwtServices)))
				.uri("http://localhost:10451/info-me"))
				.route("administrador-buscar-curriculum",p ->
				p.path("/curriculum/me")
					.and()
					.method(HttpMethod.GET)
					.filters(f ->
							f.filter(new headerFilter(jwtServices)))
					.uri("http://localhost:10451/curriculum"))
				.route("estudiante-buscar-curriculum",p ->
				p.path("/curriculum/buscar")
					.and()
					.method(HttpMethod.GET)
					.and()
					.predicate(s ->{
						return s.getRequest().getQueryParams().containsKey("user");
					})
					.filters(f ->
						f.filter(new headerFilter(jwtServices)))
					.uri("http://localhost:10451/curriculum/buscar"))
				.route("estudiante-gardar-curriculum",p ->
				p.path("/curriculum/guardar")
					.and()
					.method(HttpMethod.POST)
					.filters(f ->
						f.filter(new headerFilter(jwtServices)))
					.uri("http://localhost:10451"))
				.route("servicio-postulaciones",p ->
				p.path("/postulaciones","/postulaciones/**")
					.and()
					.method(HttpMethod.PUT,HttpMethod.GET,
							HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE)
					.filters(f ->
						f.filter(new headerFilter(jwtServices)))
					.uri("http://localhost:10452"))
				.route("servicio-gestion",p ->
				p.path("/carreras","/carreras/**","/facultades","/facultades/**",
						"/ofertas","/ofertas/**", "/empresas","/empresas/**")
				.and()
				.method(HttpMethod.PUT,HttpMethod.GET,
						HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE)
				.filters(f ->
					f.filter(new headerFilter(jwtServices)))
				.uri("http://localhost:10453"))
			
				.build();
	}
	

	@Bean  
    RouterFunction<ServerResponse> helloRoute(AuthenticationServiceImpl authHandler) {  
        return RouterFunctions.route()  
                .POST("auth/login", authHandler::loginHandler)  
                .POST("auth/refresh", authHandler::refreshTokenHandler)  
                .build();  
    }  
	
}
