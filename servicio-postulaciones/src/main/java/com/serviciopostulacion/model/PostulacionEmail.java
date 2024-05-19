package com.serviciopostulacion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostulacionEmail {

	private String email;
    private String puesto;
    private String empresa;
		
		
}
