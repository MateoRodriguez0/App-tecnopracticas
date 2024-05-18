package com.gestionpracticas.services;


import com.gestionpracticas.model.Ofertas;
import com.gestionpracticas.repositories.OfertasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.sql.Timestamp;
import java.time.LocalDateTime;
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95
import java.util.List;
import java.util.UUID;


@Service
public class OfertasService {
    private final OfertasRepository ofertasRepository;

    @Autowired
    public OfertasService(OfertasRepository ofertasRepository) {
        this.ofertasRepository = ofertasRepository;
    }

    public List<Ofertas> getAllOfertas() {
        return ofertasRepository.findAll();
    }

    public Ofertas createOferta(Ofertas ofertas) {
<<<<<<< HEAD
=======
    	ofertas.setFecha_creacion(Timestamp.valueOf(LocalDateTime.now()));
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95
        return ofertasRepository.save(ofertas);
    }

    public Ofertas getOferta(UUID id) {
        return ofertasRepository.findById(id).orElseThrow();
    }

    public Ofertas updateOferta(Ofertas ofertas) {
<<<<<<< HEAD
=======
    	ofertas.setFecha_actualizacion(Timestamp.valueOf(LocalDateTime.now()));
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95
        return ofertasRepository.save(ofertas);
    }

    public void deleteOferta(UUID id) {
        ofertasRepository.deleteById(id);
    }

    //listar ofertas por carrera
    public List<Ofertas> getOfertasByCarrera(UUID id) {
        return ofertasRepository.findByCarreraId(id);
    }


}