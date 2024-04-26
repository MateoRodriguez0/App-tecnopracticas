package com.tecnopracticas.auth.services;

import com.tecnopracticas.auth.models.AuthenticationRequest;
import com.tecnopracticas.auth.models.AuthenticationResponse;

public interface AuthenticationService {

	public AuthenticationResponse login(AuthenticationRequest credentials);
	
	public AuthenticationResponse refreshToken(AuthenticationResponse token);
}
