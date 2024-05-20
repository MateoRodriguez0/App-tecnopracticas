package com.tecnopracticas.gateway.security;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.tecnopracticas.gateway.filters.AuthorizationFilter;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {
	
	private final SecurityContextRepository securityContextRepository;  
	 
	public SecurityConfig(SecurityContextRepository securityContextRepository) {  
	        this.securityContextRepository = securityContextRepository;  
	    } 
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}

	@Bean
	SecurityWebFilterChain filterChain(ServerHttpSecurity http,AuthorizationFilter jwtFilter) {
		jwtFilter.setPaths(paths);
		http.csrf(c ->c.disable())
		.addFilterAfter(jwtFilter, SecurityWebFiltersOrder.FIRST)  
        .securityContextRepository(securityContextRepository)  
		.authorizeExchange(ex ->ex
				.pathMatchers("/auth/login").permitAll()
				.pathMatchers("/auth/refresh").permitAll()
				.pathMatchers(HttpMethod.POST,"/curriculum/guardar").hasAuthority("ESTUDIANTE")
				.pathMatchers(HttpMethod.GET,"/curriculum/me").hasAuthority("ESTUDIANTE")
				.pathMatchers(HttpMethod.GET,"/curriculum/buscar").hasAuthority("ADMINISTRADOR")
				.pathMatchers(HttpMethod.GET,"/usuarios/restablecer-clave").permitAll()
				.pathMatchers(HttpMethod.PUT,"/usuarios/restablecer-clave").permitAll()
				.pathMatchers(HttpMethod.POST,"/postulaciones/crear").hasAuthority("ESTUDIANTE")
				.pathMatchers(HttpMethod.PUT,"/postulaciones/**").hasAuthority("ADMINISTRADOR")
				.pathMatchers(HttpMethod.GET,"/postulaciones").hasAuthority("ADMINISTRADOR")
				.pathMatchers(HttpMethod.GET,"/postulaciones/**").hasAuthority("ADMINISTRADOR")
				.pathMatchers("/usuarios/verificar").permitAll()
				.pathMatchers(HttpMethod.POST,"/empresas/**").hasAuthority("ADMINISTRADOR")
				.pathMatchers(HttpMethod.PUT,"/empresas/**").hasAuthority("ADMINISTRADOR")
				.pathMatchers(HttpMethod.DELETE,"/empresas/**").hasAuthority("ADMINISTRADOR")
				.pathMatchers(HttpMethod.POST,"/ofertas/**").hasAuthority("ADMINISTRADOR")
				.pathMatchers(HttpMethod.PUT,"/ofertas/**").hasAuthority("ADMINISTRADOR")
				.pathMatchers(HttpMethod.DELETE,"/ofertas/**").hasAuthority("ADMINISTRADOR")
				.pathMatchers(HttpMethod.GET,"/facultades","/facultades/**").authenticated()
				.pathMatchers(HttpMethod.GET,"/empresas","/empresas/**").authenticated()
				.pathMatchers(HttpMethod.GET,"/ofertas","/ofertas/**").authenticated()
				.pathMatchers(HttpMethod.GET,"/carreras","/carreras/**").authenticated()
				.pathMatchers(HttpMethod.POST,"/usuarios/registrar").permitAll()
				.pathMatchers(HttpMethod.GET,"/usuarios/info-me").authenticated()
				.anyExchange().permitAll())
		.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)  
        .formLogin(ServerHttpSecurity.FormLoginSpec::disable)  
        .logout(ServerHttpSecurity.LogoutSpec::disable); 
		return http.build();
	}
	
	@Value("${tecnopracticas.pahts-permiteall}")
	private List<String> paths;

}
