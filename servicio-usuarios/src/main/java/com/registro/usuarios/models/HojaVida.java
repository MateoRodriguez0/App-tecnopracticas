package com.registro.usuarios.models;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "hojas_de_vida")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HojaVida {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "ruta_cv")
	private String ruta;
	
	@OneToOne
	@JoinColumn(name = "estudiante_id")
	private Usuario estudiante;
	
	@Column(name = "fecha_creacion")
	private Timestamp fecha_creacion;
	
}
