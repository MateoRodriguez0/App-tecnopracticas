package com.proyecto.practicas.repositories;

import com.proyecto.practicas.models.OfertaPractica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRepository extends JpaRepository<OfertaPractica,Long> {
}
