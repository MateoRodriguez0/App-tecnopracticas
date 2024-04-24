package com.registro.usuarios.repositories;

import com.registro.usuarios.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
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
    
    @Modifying
    @Query(value = "update usuarios u set email_verificado=true where u.correo_electronico=?",
    		nativeQuery = true)
    void validarCorreo(String correo);
}