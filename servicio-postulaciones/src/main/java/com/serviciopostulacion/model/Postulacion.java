package com.serviciopostulacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "postulaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "fecha_postulacion")
    private Timestamp fecha_postulacion;

    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Basic(optional = false)
    @Column(name = "estado")
    private EstadoPostulacion estadoPostulacion;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "oferta_id")
    private Oferta oferta;

}