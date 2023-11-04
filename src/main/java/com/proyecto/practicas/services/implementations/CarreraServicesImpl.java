package com.proyecto.practicas.services.implementations;

import com.proyecto.practicas.repositories.CarreraRepository;
import com.proyecto.practicas.services.CarreraServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraServicesImpl implements CarreraServices {


    @Autowired
    private CarreraRepository carreraRepository;
}
