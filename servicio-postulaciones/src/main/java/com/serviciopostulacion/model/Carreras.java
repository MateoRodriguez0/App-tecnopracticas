package com.serviciopostulacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carreras")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carreras {

	public Carreras(UUID id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "url_imagen")
	private String url_imagen;

	@Column(name = "descripcion")
	private String descripcion;
	

}