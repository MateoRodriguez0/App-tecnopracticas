package com.gestionpracticas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carreras carrera;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresas empresa;

}