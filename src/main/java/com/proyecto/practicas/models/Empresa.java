package com.proyecto.practicas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name ="empresas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   /* @Transient
    @Column(name = "nombre_completo")
    private String nombre;
   */ 
    @Column(name = "NIT")
    private Long nit;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Email(message = "El Email no es valido.")
    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdEmpresa")
    private List<OfertaPractica> ofertaPracticas;
}
