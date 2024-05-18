package com.gestionpracticas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Table(name = "ofertas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ofertas {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private Timestamp fecha_creacion;

    @Column(name = "fecha_actualizacion")
    private Timestamp fecha_actualizacion;

<<<<<<< HEAD
    @Column(name = "carrera_id")
    private UUID carrera_id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresas empresas;
=======
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carreras carrera;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresas empresa;
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95

}