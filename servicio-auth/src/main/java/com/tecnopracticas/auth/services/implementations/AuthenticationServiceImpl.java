package com.tecnopracticas.auth.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.tecnopracticas.auth.clients.UsuarioClient;
import com.tecnopracticas.auth.models.AuthenticationRequest;
import com.tecnopracticas.auth.models.AuthenticationResponse;
import com.tecnopracticas.auth.models.Usuario;
import com.tecnopracticas.auth.services.AuthenticationService;
import com.tecnopracticas.auth.services.JwtServices;


@Service
@Scope("prototype")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public AuthenticationResponse login(AuthenticationRequest request ) {
		UsernamePasswordAuthenticationToken credentials=
				new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword());
		
		manager.authenticate(credentials);
		Usuario usuario= usuarioClient.buscar(request.getUsername()).getBody();
		String jwt=jwtServices.generarToken(usuario);
		String refresToken=jwtServices.generateRefreshToken(usuario);
		return AuthenticationResponse.builder()
				.token(jwt)
				.user_id(usuario.getId())
				.refreshToken(refresToken)
				.expires_in(60*20)
				.build();
	}

	@Override
	public AuthenticationResponse refreshToken(AuthenticationResponse token) {
		if(jwtServices.isRefreshTokenValid(token.getToken())) {
			Usuario usuario= usuarioClient
					.buscar(jwtServices.ExtractUsername(token.getToken())).getBody(); 
			
			String jwt=jwtServices.generarToken(usuario);
			String refresToken=jwtServices.generateRefreshToken(usuario);
			return AuthenticationResponse.builder()
					.token(jwt)
					.user_id(usuario.getId())
					.refreshToken(refresToken)
					.expires_in(60*20)
					.build();	
		}
		return null;	
	}
	

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtServices jwtServices;
	
	@Autowired
	private UsuarioClient usuarioClient;

	
}
