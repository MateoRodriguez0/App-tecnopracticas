package com.registro.usuarios.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
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
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fecha_registro")
    private String fecha_registro;

}