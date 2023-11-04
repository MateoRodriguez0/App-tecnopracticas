package com.proyecto.practicas.services.implementations;

import com.proyecto.practicas.repositories.RolRepository;
import com.proyecto.practicas.services.RolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServicesImpl implements RolServices {

    @Autowired
    private RolRepository rolRepository;
}
