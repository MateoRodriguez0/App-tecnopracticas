package com.registro.usuarios.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RestablecerClave {

	private String clave_nueva;
	private String token;
}
