package com.gestionpracticas.repositories;

import com.gestionpracticas.model.Carreras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CarrerasRepository extends JpaRepository<Carreras, UUID> {
    @Query(value = "SELECT u.id, u.nombre, u.facultad_id, u.url_imagen, u.descripcion from carreras u where u.facultad_id = ?",
            nativeQuery = true)
    List<Carreras> findByFacultadId(UUID Id);
}