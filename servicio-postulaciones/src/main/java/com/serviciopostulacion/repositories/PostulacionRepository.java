package com.serviciopostulacion.repositories;

import com.serviciopostulacion.model.Postulacion;
import com.serviciopostulacion.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostulacionRepository extends JpaRepository<Postulacion, UUID> {
	
   List<Postulacion> findByUsuario(Usuario usuario);
 
}
