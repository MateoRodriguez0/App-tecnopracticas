package com.proyecto.practicas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name ="usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_completo")
    private String nombre;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "fecha_nacimiento")
    private Date fNacimiento;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "IdRol")
    private Rol rol;

    @OneToMany(mappedBy = "estudiante")
    private List<Postulacion> postulaciones;

    /*
    @OneToMany(mappedBy = "admin")
    private List<OfertaPractica> ofertaPracticas;
    */
}
