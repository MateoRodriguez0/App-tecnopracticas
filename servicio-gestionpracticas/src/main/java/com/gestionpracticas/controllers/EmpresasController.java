package com.gestionpracticas.controllers;

import com.gestionpracticas.model.Empresas;
import com.gestionpracticas.services.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {
    @Autowired
    private EmpresasService empresasService;

    @GetMapping
    public List<Empresas> getAllEmpresas() {
        return empresasService.getAllEmpresas();
    }

    @GetMapping("/{id}")
    public Empresas getEmpresaById(@PathVariable UUID id) {
        return empresasService.getEmpresaById(id);
    }

    @PostMapping("/create")
    public Empresas createEmpresa(@RequestBody Empresas empresas) {
        return empresasService.createEmpresa(empresas);
    }

    @PutMapping("/update/{id}")
    public Empresas updateEmpresa(@PathVariable UUID id, @RequestBody Empresas empresas) {
        return empresasService.updateEmpresa(id, empresas);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmpresa(@PathVariable UUID id) {
        empresasService.deleteEmpresa(id);
    }
}
