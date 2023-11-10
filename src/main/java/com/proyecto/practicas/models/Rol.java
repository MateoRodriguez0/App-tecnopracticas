package com.proyecto.practicas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="empresas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "nombre")
    private String nombre;
}
