package com.gestionpracticas.services;


import com.gestionpracticas.model.Carreras;
import com.gestionpracticas.model.Empresas;
import com.gestionpracticas.model.Ofertas;
import com.gestionpracticas.repositories.CarrerasRepository;
import com.gestionpracticas.repositories.EmpresasRepository;
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
    private final OfertasRepository ofertasRepository;
    @Autowired
    private CarrerasRepository carrerasRepository;
    @Autowired
    private EmpresasRepository empresasRepository;


    @Autowired
    public OfertasService(OfertasRepository ofertasRepository) {
        this.ofertasRepository = ofertasRepository;
    }

    public List<Ofertas> getAllOfertas() {
        return ofertasRepository.findAll();
    }

    public Ofertas createOferta(Ofertas ofertas) {
        ofertas.setFecha_creacion(Timestamp.valueOf(LocalDateTime.now()));
        return ofertasRepository.save(ofertas);
    }

    public Ofertas getOferta(UUID id) {
        return ofertasRepository.findById(id).orElseThrow();
    }

    public Ofertas updateOferta(Ofertas ofertas) {
        ofertas.setFecha_actualizacion(Timestamp.valueOf(LocalDateTime.now()));
        return ofertasRepository.save(ofertas);
    }

    public void deleteOferta(UUID id) {
        ofertasRepository.deleteById(id);
    }

    public List<Ofertas> getOfertasByEmpresas(UUID id) {
        Empresas empresa = empresasRepository.findById(id).orElseThrow();
        return ofertasRepository.findByEmpresa(empresa);
    }

    public List<Ofertas> getOfertasByCarreras(UUID id) {
        Carreras carrera = carrerasRepository.findById(id).orElseThrow();
        return ofertasRepository.findByCarrera(carrera);
    }

}