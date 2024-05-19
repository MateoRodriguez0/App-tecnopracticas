package com.serviciopostulacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
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

    @Column(name = "nombre_completo")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo_electronico")
    private String correo;

    @Column(name = "email_verificado")
    private boolean verificado;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "password")
    private String password;

    @Column(name = "carrera_id")
    private UUID carrera;

    @Column(name = "fecha_registro")
    private Timestamp fecha_registro;
}
