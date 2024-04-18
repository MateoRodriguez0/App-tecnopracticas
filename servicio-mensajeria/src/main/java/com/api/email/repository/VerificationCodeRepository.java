package com.api.email.repository;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.email.models.entity.VerificationCode;


import com.api.email.models.entity.TipoVerification;


public interface VerificationCodeRepository extends JpaRepository<VerificationCode, UUID>{

	VerificationCode findByEmail(String email);
	boolean existsByEmail(String email);
	void deleteByEmail(String email);
	boolean existsByEmailAndTipo(String email, TipoVerification tipo);
	
	
	@Query(value = "select fecha_expiracion from verificaciones as v "
			+ "where v.correo_electronico=? and CAST(v.tipo AS character varying)=?",nativeQuery = true)
	Date getExpirationByEmail(String email,String tipo);
	
	@Query(value = "select v.id, v.correo_electronico, v.codigo, v.fecha_expiracion, v.tipo"
			+ " from verificaciones as v join usuarios as u "
			+ "	on v.correo_electronico = u.correo_electronico"
			+ "	where u.id=? and v.codigo=?", nativeQuery = true)
	VerificationCode getByUserIdAndCode(UUID userId, String codigo);

	@Query(value = "select u.id from usuarios u where u.correo_electronico=?",nativeQuery = true)
	UUID getidOfUserByEmail(String email);
}




