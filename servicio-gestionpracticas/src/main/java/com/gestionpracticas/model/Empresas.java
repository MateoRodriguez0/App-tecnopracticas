package com.gestionpracticas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95
import java.util.UUID;

@Entity
@Table(name = "empresas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresas {
<<<<<<< HEAD
=======
	
	public Empresas(UUID id) {
		this.id=id;
	}
	
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_registro")
    private Timestamp fecha_registro;
<<<<<<< HEAD
=======
    
    @OneToMany(mappedBy = "empresa")
    private List<Ofertas> ofertas;
    
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95

}
