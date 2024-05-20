package com.serviciopostulacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    public Usuario(UUID id) {
		super();
		this.id = id;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo_electronico")
    private String correo;

    @Column(name = "carrera_id")
    private UUID carrera;

   
}
