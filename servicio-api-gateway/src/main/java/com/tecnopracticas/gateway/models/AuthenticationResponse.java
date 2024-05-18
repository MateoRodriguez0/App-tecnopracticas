package com.tecnopracticas.gateway.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
	
	public AuthenticationResponse(String token) {
		this.token=token;
	}
	private String token;
	private int expires_in;
	private UUID user_id;
	private String refreshToken;
}
