package com.api.email.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.email.models.entity.Usuario;

public interface UsuariosRespository extends JpaRepository<Usuario,UUID>{

	@Query(value = "select u.nombre_completo from usuarios u where u.correo_electronico=?",
			nativeQuery = true)
	String getnombreByEmail(String email);
}
