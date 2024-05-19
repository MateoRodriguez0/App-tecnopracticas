package com.serviciopostulacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serviciopostulacion.model.Usuario;


import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
	
	 @Query(value = "select u.correo_electronico from usuarios u where u.id=?", nativeQuery = true)
	 String getemailById(UUID id);

	 @Query(value = "SELECT u.carrera_id from usuarios u where u.id=?",nativeQuery = true)
	 UUID getIdCarreraByUsuario(UUID id );
		
	
}