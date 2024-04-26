package com.tecnopracticas.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class HttpSecurityConfig {

	 @Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity config) throws Exception {
		 config.sessionManagement(s ->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		 .csrf(c ->c.disable())
		 .authenticationProvider(authenticationProvider)
		 .authorizeHttpRequests(http ->http.anyRequest().permitAll());
		 return config.build();
	 }


	@Autowired
	private AuthenticationProvider authenticationProvider;
		
}
