package com.gestionpracticas.repositories;

import com.gestionpracticas.model.Empresas;
import com.gestionpracticas.model.Ofertas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmpresasRepository extends JpaRepository<Empresas, UUID> {
}
