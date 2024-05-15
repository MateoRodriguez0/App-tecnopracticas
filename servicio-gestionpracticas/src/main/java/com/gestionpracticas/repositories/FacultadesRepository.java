package com.gestionpracticas.repositories;

import com.gestionpracticas.model.Facultades;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FacultadesRepository extends JpaRepository <Facultades, UUID> {
    @Override
    List<Facultades> findAll();
}
