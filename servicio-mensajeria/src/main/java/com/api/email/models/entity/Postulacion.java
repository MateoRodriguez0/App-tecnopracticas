package com.api.email.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Postulacion {
	
	public Postulacion(String email_usuario, String nombre_oferta, String empresa) {
		super();
		this.email_usuario = email_usuario;
		this.nombre_oferta = nombre_oferta;
		this.empresa = empresa;
	}
	private String email_usuario;
    private String nombre_oferta;
    private String empresa;
    private String nombre_usuario;


}
