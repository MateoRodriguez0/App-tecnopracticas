package com.registro.usuarios.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario {
	
    public Usuario(String nombre, /*String telefono,*/ String correo, String password,
			UUID carrera) {
		super();
		this.nombre = nombre;
		//this.telefono = telefono;
		this.correo = correo;
		this.password = password;
		this.carrera = carrera;
	}
    
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

	@Length(min = 5,message = "El nombre es muy corto")
	@NotBlank(message = "El nombre no puede estar vacio")
    @Column(name = "nombre_completo")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Email
    @Column(name = "correo_electronico")
    private String correo;

    @Column(name = "email_verificado")
    private boolean verificado;
    
    @Column(name = "activo")
    private boolean activo;

    @Length(min = 8,message = "la clave debe tener minimo 8 caracteres")
    @Column(name = "password")
    private String password;
    
    @NotNull
    @Column(name = "carrera_id")
    private UUID carrera;

    @Column(name = "fecha_registro")
    private Timestamp fecha_registro;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_usuario",
    joinColumns = {@JoinColumn(name="usuario_id")}, inverseJoinColumns = @JoinColumn(name="rol_id"))
    private List<Rol> roles;

    public boolean passwordIsValid() {
    	return this.password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+.=]).{8,}");
    }


}