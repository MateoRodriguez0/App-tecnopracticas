package com.tecnopracticas.gateway.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Rol {
	
	@JsonIgnore
	private UUID id;
	private String nombre;	
}
