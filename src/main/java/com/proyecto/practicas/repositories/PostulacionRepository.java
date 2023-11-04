package com.proyecto.practicas.repositories;


import com.proyecto.practicas.models.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulacionRepository extends JpaRepository<Postulacion,Long> {
}
