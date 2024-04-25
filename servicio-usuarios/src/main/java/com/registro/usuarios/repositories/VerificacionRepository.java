package com.registro.usuarios.repositories;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.registro.usuarios.models.TipoVerification;
import com.registro.usuarios.models.Verificacion;





public interface VerificacionRepository extends JpaRepository<Verificacion, UUID>{

	Verificacion findByEmail(String email);
	boolean existsByEmail(String email);
	void deleteByEmail(String email);
	boolean existsByEmailAndTipo(String email, TipoVerification tipo);
	
	@Query(value = "select v.id, v.correo_electronico, v.codigo, v.fecha_expiracion, v.tipo"
			+ " from verificaciones as v join usuarios as u "
			+ "	on v.correo_electronico = u.correo_electronico"
			+ "	where u.correo_electronico=? and CAST(v.tipo AS character varying)=?",nativeQuery = true)
	Verificacion findByEmailAndTipo(String email, String tipo);
	
	@Query(value = "select fecha_expiracion from verificaciones as v "
			+ "where v.correo_electronico=? and CAST(v.tipo AS character varying)=?",nativeQuery = true)
	Date getExpirationByEmail(String email,String tipo);

	@Query(value = "select v.id, v.correo_electronico, v.codigo, v.fecha_expiracion, v.tipo"
			+ " from verificaciones as v join usuarios as u "
			+ "	on v.correo_electronico = u.correo_electronico"
			+ "	where v.correo_electronico=? and v.codigo=?", nativeQuery = true)
	Verificacion findByCorreoAndCodigo(String correo, String codigo);
	
	@Query(value = "select u.id from usuarios u where u.correo_electronico=?",nativeQuery = true)
	UUID getidOfUserByEmail(String email);

	@Query(value = "select v.id from verificaciones v where v.correo_electronico=? and" +
			" CAST(v.tipo AS character varying)=?",nativeQuery = true)
	UUID getidOfVerificacionType(String email,String tipo);
	
	@Modifying
	@Query(value = "delete from verificaciones v where v.correo_electronico=? and" +
			" CAST(v.tipo AS character varying)=?",nativeQuery = true)
	void eliminarVerificacionCuenta(String email,String tipo);

}




