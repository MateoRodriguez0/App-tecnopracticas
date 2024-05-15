package com.gestionpracticas.services;

import com.gestionpracticas.model.Carreras;
import com.gestionpracticas.model.Facultades;
import com.gestionpracticas.repositories.CarrerasRepository;
import com.gestionpracticas.repositories.FacultadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FacultadesService {
    @Autowired
    private FacultadesRepository facultadesRepository;
    @Autowired
    private CarrerasRepository carrerasRepository;

    public List<Facultades> getAllFacultades() {
        return facultadesRepository.findAll();
    }

    public List<Carreras> getCarrerasByFacultadesId(UUID id) {
        return carrerasRepository.findByFacultadId(id);
    }
}