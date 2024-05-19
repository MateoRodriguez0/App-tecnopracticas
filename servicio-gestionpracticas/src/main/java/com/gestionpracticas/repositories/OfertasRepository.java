package com.gestionpracticas.repositories;

import com.gestionpracticas.model.Carreras;
import com.gestionpracticas.model.Empresas;
import com.gestionpracticas.model.Ofertas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OfertasRepository extends JpaRepository<Ofertas, UUID> {
    @Query(value = "SELECT u.id, u.nombre, u.descripcion, u.fecha_creacion, u.fecha_actualizacion, u.empresa_id, u.carrera_id, u.publicado_por FROM ofertas u where u.carrera_id  = ?",
            nativeQuery = true)

    List<Ofertas> findByCarreraId(UUID Id);

    List<Ofertas> findByEmpresa(Empresas empresa);

    List<Ofertas> findByCarrera(Carreras carrera);
}