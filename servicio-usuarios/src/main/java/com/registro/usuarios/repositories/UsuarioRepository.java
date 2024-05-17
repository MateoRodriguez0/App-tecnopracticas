package com.registro.usuarios.repositories;

import com.registro.usuarios.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    boolean existsByCorreo(String email);
    
    Usuario findByCorreo(String correo);
    
    @Query(value = "select u.email_verificado from usuarios u where u.correo_electronico=?",
    		nativeQuery = true)
    boolean correoVerificado(String correo);

    
    @Query(value = "select u.id from usuarios u where u.correo_electronico=?",
    		nativeQuery = true)
    UUID getIdByCorreo(String correo);
    
    @Query(value = "select u.fecha_registro from usuarios u where u.correo_electronico=?",
    		nativeQuery = true)
    Timestamp getFechaRegistrpByCorreo(String correo);
    
    @Modifying
    @Query(value = "update usuarios u set email_verificado=true where u.correo_electronico=?",
    		nativeQuery = true)
    void validarCorreo(String correo);
    
    
    @Modifying
    @Query(value = "update usuarios u set password=? where u.correo_electronico=?",
    		nativeQuery = true)
    void restablecerclave(String clave, String correo);
    
	@Modifying
	@Query(value = "update usuarios set activo=true where correo_electronico=? " ,nativeQuery =  true)
	void habilitarUsuario(String correo );
	
	 @Query(value = "select c.nombre from usuarios u join carreras c on c.id=u.carrera_id"
	 		+ " where u.id=?",
	    		nativeQuery = true)
	 String buscarCarreraByUsuario(UUID id);

	
}