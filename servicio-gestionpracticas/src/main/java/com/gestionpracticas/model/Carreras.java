package com.gestionpracticas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95
import java.util.UUID;

@Entity
@Table(name = "carreras")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carreras {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "url_imagen")
    private String url_imagen;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultades facultades;
<<<<<<< HEAD
=======
    
    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<Ofertas> ofertas;
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95

}