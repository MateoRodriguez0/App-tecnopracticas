package com.serviciopostulacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "postulaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Postulacion {

	public Postulacion(Oferta oferta) {
		this.oferta = oferta;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "fecha_postulacion")
    private Timestamp fecha_postulacion;

	@JdbcTypeCode(SqlTypes.NAMED_ENUM)
	@Basic(optional = false)
	@Column(name = "estado", nullable = false)
    private EstadoPostulacion estadoPostulacion;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "oferta_id")
    private Oferta oferta;

}