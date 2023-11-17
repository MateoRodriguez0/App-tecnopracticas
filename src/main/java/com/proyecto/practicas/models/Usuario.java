package com.proyecto.practicas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.sql.Date;
import java.util.List;

import com.proyecto.practicas.util.validation.EmailInstitucional;
import com.proyecto.practicas.util.validation.Password;

@Entity
@Table(name ="usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 5, max = 45,message = "El campo nombre no esta bien")
    @NotEmpty(message = "El campo nombre no puede estar vacio")
    @Column(name = "nombre_completo")
    private String nombre;
    
    @NotEmpty(message = "El sexo campo no puede estar vacio")
    @Column(name = "sexo")
    private String sexo;
    
    @NotEmpty(message = "El campo telefono no puede estar vacio")
    @Column(name = "telefono")
    private String telefono;
    
    @NotNull(message = "El campo fecha de nacimiento no puede estar vacio")
    @Column(name = "fecha_nacimiento")
    private Date fNacimiento;
    
    @Email()
    @EmailInstitucional()
    @NotEmpty(message = "El campo email no puede estar vacio")
    @Column(name = "email")
    private String email;
    
    @Password
    @NotEmpty(message = "El campo password no puede estar vacio")
    @Column(name = "password")
    private String password;

    @Password(message = "El campo verificación de cintraseña no es valido")
	@Transient
	@NotBlank(message = "El campo  verificación de contraseña no puede estar en blanco")
	@NotEmpty(message = "El campo verificación de contraseña no puede estar vacio")
	private String passwordValid;
    
    @OneToOne
    @JoinColumn(name = "IdRol")
    private Rol rol;

    @OneToMany(mappedBy = "estudiante")
    private List<Postulacion> postulaciones;

    /*
    @OneToMany(mappedBy = "admin")
    private List<OfertaPractica> ofertaPracticas;
    */
    
    
    
    /**
	 * verifica si la contraseña y la verificacion de contraseña son iguales.
	 * 
	 * @return true si son iguales o falso si no.
	 */
	public Boolean validPasword() {
		
		return password.equals(passwordValid);
	}
	
	public Boolean esMayordeEdad() {
		LocalDate fechaNacimiento=fNacimiento.toLocalDate();
		Period periodo=Period.between(fechaNacimiento, LocalDate.now());
		
		return periodo.getYears()>=18;
	}
}
