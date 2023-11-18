package com.proyecto.practicas.repositories;

import com.proyecto.practicas.models.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

public interface UserRepository extends JpaRepository<Usuario,Long>{

    Boolean ExistByEmail(String email);

}
