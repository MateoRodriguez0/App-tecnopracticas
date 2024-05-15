package com.serviciopostulacion.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}

