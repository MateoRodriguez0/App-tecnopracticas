package com.proyecto.practicas.repositories;

import com.proyecto.practicas.models.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<Usuario,Long>{
	
	boolean existsByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);
	

}
