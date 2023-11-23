package com.proyecto.practicas.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.practicas.models.Empresa;
import com.proyecto.practicas.models.OfertaPractica;
import com.proyecto.practicas.services.CarreraServices;
import com.proyecto.practicas.services.OfertaServices;

@Controller
@RequestMapping(value = "/tecnopracticas")
public class OfertasController {
	
	
	private final String urlOfertas="ofertas/Ofertas";
	
	@GetMapping(value = "/carrera/ofertas/{id}")
	public String getOfertasPorCarrera(@PathVariable(name = "id")Long id,Model model) {
		
	    List<OfertaPractica> listaOfertas = new ArrayList<>();

        // Crear y agregar 10 ofertas con empresas diferentes
        for (int i = 1; i <= 10; i++) {
            OfertaPractica oferta = new OfertaPractica();
            oferta.setNombre("Oferta " + i);
            oferta.setDescripcion("Descripción de la oferta " + i);
            oferta.setFecha(new Timestamp(System.currentTimeMillis())); // Establecer la fecha actual

            // Crear y establecer empresa para la oferta
            Empresa empresa = new Empresa();
            empresa.setNit((long) (1000000000 + i)); // Ejemplo simple de NIT
            empresa.setTelefono("12345678");
            empresa.setNombre("aws");
            empresa.setDireccion("Dirección de la empresa " + i);
            empresa.setEmail("empresa" + i + "@ejemplo.com");

            // Agregar la oferta a la lista
            oferta.setEmpresa(empresa);
            listaOfertas.add(oferta);
        }
		
		List<OfertaPractica> ofertas=ofertaServices.getOfertasPorCarrera(id);
		
		model.addAttribute("ofertas", listaOfertas);
		model.addAttribute("carrera", carreraServices.getCarreraById(id));
		
		return urlOfertas;
	}
	
	
	
	
	
	@Autowired
	private OfertaServices ofertaServices;
	
	@Autowired
	private CarreraServices carreraServices;
}
