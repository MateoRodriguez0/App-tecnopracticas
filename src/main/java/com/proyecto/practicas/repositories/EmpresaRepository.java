package com.proyecto.practicas.repositories;

import com.proyecto.practicas.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
