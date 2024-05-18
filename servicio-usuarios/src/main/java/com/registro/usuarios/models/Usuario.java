package com.registro.usuarios.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Usuario {
	
    public Usuario(String nombre, /*String telefono,*/ String correo, String password,
			UUID carrera) {
		super();
		this.nombre = nombre;
		//this.telefono = telefono;
		this.correo = correo;
		this.password = password;
		this.carrera_id = carrera;
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
    
    @JsonIgnore
    @Column(name = "carrera_id")
    private UUID carrera_id;
    
    @Transient 
    private String carrera;

    @Column(name = "fecha_registro")
    private Timestamp fecha_registro;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_usuario",
    joinColumns = {@JoinColumn(name="usuario_id")}, inverseJoinColumns = @JoinColumn(name="rol_id"))
    private List<Rol> roles;

}