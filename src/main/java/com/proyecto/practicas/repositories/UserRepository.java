package com.proyecto.practicas.repositories;

import com.proyecto.practicas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Long>{
}
