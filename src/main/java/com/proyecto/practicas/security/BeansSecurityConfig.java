package com.proyecto.practicas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
		.requestMatchers("/css/**","/images/**","/js/**")
		.permitAll()
		.requestMatchers("/tecnopracticas/cuentas/login")
		.permitAll()
		.requestMatchers("/tecnopracticas")
		.permitAll()
		.requestMatchers("/tecnopracticas",
				"/tecnopracticas/cuentas/singup",
				"/tecnopracticas/cuentas/login")
		.anonymous()
		.requestMatchers(HttpMethod.GET,"/tecnopracticas/ofertas/nueva")
		.hasAuthority("ADMINISTRADOR")
		.requestMatchers(HttpMethod.POST,"/tecnopracticas/ofertas/nueva")
		.hasAuthority("ADMINISTRADOR")
		.requestMatchers("/tecnopracticas/carrera/ofertas/**")
		.hasAnyAuthority("ESTUDIANTE","ADMINISTRADOR")
		.requestMatchers("/tecnopracticas/myaccount")
		.hasAnyAuthority("ESTUDIANTE","ADMINISTRADOR")
		.requestMatchers("/tecnopracticas/logout").authenticated()
		.anyRequest().authenticated())

		.formLogin(login ->login.loginPage("/tecnopracticas/cuentas/login").permitAll());
		http.logout(Customizer.withDefaults());
		return http.build();
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
