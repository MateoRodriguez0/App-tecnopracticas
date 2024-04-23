package com.registro.usuarios.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.models.Rol;

public interface RolesRepository extends JpaRepository<Rol, UUID> {

	Rol findByNombre(String nombre);
}
