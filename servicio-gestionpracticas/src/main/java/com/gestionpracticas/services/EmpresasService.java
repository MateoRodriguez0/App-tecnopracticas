package com.gestionpracticas.services;

import com.gestionpracticas.model.Empresas;
import com.gestionpracticas.repositories.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.sql.Timestamp;
import java.time.Instant;
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95
import java.util.List;
import java.util.UUID;

@Service
public class EmpresasService {
    @Autowired
    private EmpresasRepository empresasRepository;

    public List<Empresas> getAllEmpresas() {
        return empresasRepository.findAll();
    }

    public Empresas getEmpresaById(UUID id) {
        return empresasRepository.findById(id).orElseThrow();
    }

    public Empresas createEmpresa(Empresas empresa) {
<<<<<<< HEAD
=======
    	empresa.setFecha_registro(Timestamp.from(Instant.now()));
>>>>>>> a19ca288ca89986a7c55ea541e529da97054fa95
        return empresasRepository.save(empresa);
    }

    public Empresas updateEmpresa(UUID id, Empresas empresa) {
        Empresas existingEmpresa = getEmpresaById(id);
        existingEmpresa.setNombre(empresa.getNombre());
        existingEmpresa.setTelefono(empresa.getTelefono());
        existingEmpresa.setDireccion(empresa.getDireccion());
        existingEmpresa.setEmail(empresa.getEmail());
        return empresasRepository.save(existingEmpresa);
    }

    public void deleteEmpresa(UUID id) {
        empresasRepository.deleteById(id);
    }
}