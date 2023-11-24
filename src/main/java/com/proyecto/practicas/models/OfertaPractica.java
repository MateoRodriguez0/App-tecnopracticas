package com.proyecto.practicas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;




@Entity
@Table(name ="ofertas_practicas")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfertaPractica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre de oferta no puede estar vacio")
    @Column(name = "nombre_oferta")
    private String nombre;
    

    
    @NotEmpty(message = "El descripcion no puede estar vacio")
    @Column(name = "descripcion")
    private String descripcion;

    
    @ManyToOne()
    @JoinColumn(name = "idAdministrador")
    private Usuario adimn;
    
    @ManyToOne
    @JoinColumn(name = "IdEmpresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "IdCarrera")
    private Carrera carrera;

   
    @Column(name = "fecha_publicacion")
    private Timestamp fecha;

    @Column(name = "detalles")
    private String detalles;


}
