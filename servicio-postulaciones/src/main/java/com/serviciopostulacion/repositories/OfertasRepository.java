package com.serviciopostulacion.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.serviciopostulacion.model.Empresa;
import com.serviciopostulacion.model.Oferta;

import java.util.List;
import java.util.UUID;

public interface OfertasRepository extends JpaRepository<Oferta, UUID> {
    
	@Query(value = "SELECT u.id, u.nombre, u.descripcion, u.fecha_creacion, u.fecha_actualizacion, "
			+ "u.empresa_id, u.carrera_id, u.publicado_por FROM ofertas u where u.carrera_id  = ?",
            nativeQuery = true)
    List<Oferta> findByCarreraId(UUID Id);
	
	@Query(value = "SELECT e.nombre from ofertas o inner join empresas e "
			+ "on o.empresa_id=e.id where o.id= ?",nativeQuery = true)
	String getNombreEmpresaByOferta(UUID id );
	
	@Query(value = "SELECT o.nombre from ofertas o where o.id= ?",nativeQuery = true)
	String getNombrePuestoByOferta(UUID id );
	
	@Query(value = "SELECT o.carrera_id from ofertas o where o.id= ?",nativeQuery = true)
	UUID getIdCarreraByOferta(UUID id );
	
	List<Oferta> findByEmpresa(Empresa empresa);
	
	List<Oferta> findByCarrera(UUID carrera);
}