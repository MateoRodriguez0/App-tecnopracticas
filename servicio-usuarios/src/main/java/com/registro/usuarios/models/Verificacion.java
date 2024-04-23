package com.registro.usuarios.models;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "verificaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Verificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "correo_electronico",length = 150)
	private String email;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name = "fecha_expiracion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiracion;
	
	@JdbcTypeCode(SqlTypes.NAMED_ENUM)
	@Basic(optional = false)
	@Column(name = "tipo", nullable = false)
	private TipoVerification tipo;
	
	public Verificacion(String email,String code) {
		this.codigo =code;
		this.email=email;
	}
}
