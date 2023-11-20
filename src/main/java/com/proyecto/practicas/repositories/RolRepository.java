package com.proyecto.practicas.repositories;

import com.proyecto.practicas.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface RolRepository extends JpaRepository<Rol,Long>{

	 List<Rol> findAllOrderByNombre();
	
	
}
