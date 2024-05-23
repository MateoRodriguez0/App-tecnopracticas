package com.gestionpracticas.services;


import com.gestionpracticas.model.Carreras;
import com.gestionpracticas.model.Empresas;
import com.gestionpracticas.model.Ofertas;
import com.gestionpracticas.repositories.OfertasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class OfertasService {
	
    @Autowired
    private OfertasRepository ofertasRepository;

    public List<Ofertas> getAllOfertas() {
        return ofertasRepository.findAll();
    }

    public Ofertas createOferta(Ofertas ofertas,UUID id) {
    	ofertas.setPublicado_por(id);
        ofertas.setFecha_creacion(Timestamp.valueOf(LocalDateTime.now()));
        return ofertasRepository.save(ofertas);
    }

    public Ofertas getOferta(UUID id) {
        return ofertasRepository.findById(id).orElse(null);
    }

    public Ofertas updateOferta(Ofertas ofertas,UUID id) {
    	Ofertas oferta= ofertasRepository.findById(id).orElse(null);
    	oferta.setDescripcion(ofertas.getDescripcion());
    	oferta.setEmpresa(ofertas.getEmpresa());
    	oferta.setCarrera(ofertas.getCarrera());
    	ofertas.setFecha_actualizacion(Timestamp.valueOf(LocalDateTime.now()));
        return ofertasRepository.save(ofertas);
    }

    public void deleteOferta(UUID id) {
        ofertasRepository.deleteById(id);
    }

    public List<Ofertas> getOfertasByEmpresas(UUID id) {
        Empresas empresa = new Empresas(id);
        return ofertasRepository.findByEmpresa(empresa);
    }

    public List<Ofertas> getOfertasByCarreras(UUID id) {
        Carreras carrera = new Carreras(id);
        return ofertasRepository.findByCarrera(carrera);
    }

}