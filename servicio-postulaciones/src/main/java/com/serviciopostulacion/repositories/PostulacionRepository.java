package com.serviciopostulacion.repositories;

import com.serviciopostulacion.model.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PostulacionRepository extends JpaRepository<Postulacion, UUID> {
    Optional<Postulacion> findById(UUID Id);
}
