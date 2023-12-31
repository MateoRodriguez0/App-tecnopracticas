package com.proyecto.practicas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name ="carreras")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(name = "urlImagen")
    private String urlImagen;
    
    
    @Column(name = "nombre_carrera")
    private String nombre;

    
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "carrera")
    private List<OfertaPractica> ofertaPracticas;

}
