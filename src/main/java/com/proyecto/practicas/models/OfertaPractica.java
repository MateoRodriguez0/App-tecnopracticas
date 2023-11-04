package com.proyecto.practicas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name ="ofertas_practicas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfertaPractica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_oferta")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
   /* @ManyToOne()
    @JoinColumn(name = "")
    private Usuario adimn;
*/
    @ManyToOne
    @JoinColumn(name = "IdEmpresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "IdCarrera")
    private Carrera carrera;

    @Column(name = "fecha_publicacion")
    private Timestamp fecha;
}
