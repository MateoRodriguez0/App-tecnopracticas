package com.proyecto.practicas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.proyecto.practicas.models.Usuario;
import com.proyecto.practicas.services.UserService;

@Configuration
@EnableWebSecurity
public class BeansSecurityConfig {

	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(httpCustom -> 
		
		httpCustom
		.requestMatchers("/cs/**","/images/**","/js/**").permitAll()
		.requestMatchers("/tecnopracticas/cuentas/login").permitAll()
		.requestMatchers("/tecnopracticas/").hasAnyAuthority("ESTUDIANTE","ADMINISTRADOR")
		.requestMatchers("/tecnopracticas/").hasAuthority("")
		.requestMatchers("/tecnopracticas/").hasAuthority("")
		.requestMatchers("/tecnopracticas/").hasAuthority("")
		.anyRequest().authenticated())
		
		.formLogin(login ->login.loginPage("/tecnopracticas/cuentas/login").permitAll());
		return http.build();
	}
	
	@Bean 
	AuthenticationManager authenticationManager(UserDetailsService detailsService, PasswordEncoder encoder) { 
		
		DaoAuthenticationProvider daoAuthenticationProvider=
				new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(detailsService);
		daoAuthenticationProvider.setPasswordEncoder(encoder);
		
		ProviderManager manager = new ProviderManager(daoAuthenticationProvider);
		
		
		return manager;
		
	}
	
	
	@Bean
	UserDetailsService detailsService() {
		
		return username -> {
			
			Usuario usuario= userService.getUsuarioByEmail(username);
			
			if(username != null) {
				return new DetailsUsuario(usuario);
			}
			
			else {
				throw new UsernameNotFoundException("El usuario no existe");
			}
		};
		
	
	}
	
	
	@Bean 
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserService userService;
}
