package com.registro.usuarios.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.registro.usuarios.models.HojaVida;
import com.registro.usuarios.models.Usuario;


public interface HojasVidaRepository extends JpaRepository<HojaVida, UUID> {

	boolean existsByEstudiante(Usuario estudiante);
	
	@Query(value = "select h.id, h.estudiante_id, h.ruta_cv, h.fecha_creacion from hojas_de_vida h where  h.estudiante_id=?",
    		nativeQuery = true)
    HojaVida getByEstudianteId(UUID id);
	
	@Query(value = "select h.ruta_cv from hojas_de_vida h where  h.estudiante_id=?",
    		nativeQuery = true)
    String getRutaByEstudianteId(UUID id);

}
