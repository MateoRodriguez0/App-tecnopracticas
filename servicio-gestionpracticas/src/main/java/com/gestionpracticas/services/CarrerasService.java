package com.gestionpracticas.services;

import com.gestionpracticas.model.Carreras;
import com.gestionpracticas.repositories.CarrerasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarrerasService {
    @Autowired
    private CarrerasRepository carrerasRepository;

    public List<Carreras> getAllCarreras() {
        return carrerasRepository.findAll();
    }

    public Optional<Carreras> getCarreraById(UUID id) {
        return carrerasRepository.findById(id);
    }
}
