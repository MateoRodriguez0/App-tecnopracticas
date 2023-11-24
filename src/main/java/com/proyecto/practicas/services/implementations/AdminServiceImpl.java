package com.proyecto.practicas.services.implementations;

import com.proyecto.practicas.repositories.OfertaRepository;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.proyecto.practicas.models.OfertaPractica;
import com.proyecto.practicas.models.Usuario;
import com.proyecto.practicas.services.AdminServices;
import com.proyecto.practicas.services.CarreraServices;
import com.proyecto.practicas.services.EmpresaServices;
import com.proyecto.practicas.services.OfertaServices;
import com.proyecto.practicas.services.UserService;

@Service
public class AdminServiceImpl implements AdminServices {

	@Override
	public void RegistrarAdmin(Usuario usuario) {
		
	}


	@Override
	public void publicarOferta(OfertaPractica ofertaPractica,Authentication authentication){

		ofertaPractica.setAdimn(userService.getUsuarioByEmail(authentication.getName()));
		ofertaPractica.setFecha(new Timestamp(System.currentTimeMillis()));
		
		ofertaRepository.save(ofertaPractica);
	}

	@Override
	public void actualizarOferta(OfertaPractica ofertaPractica){
		
		OfertaPractica ofertaExistente=ofertaServices.getOfertaById(ofertaPractica.getId());
		ofertaExistente.setNombre(ofertaPractica.getNombre());
		ofertaExistente.setCarrera(carreraServices.getCarreraById(ofertaPractica.getCarrera().getId()));
		ofertaExistente.setEmpresa(empresaServices.getEmpresaByid(ofertaPractica.getEmpresa().getId()));
		ofertaExistente.setDescripcion(ofertaPractica.getDescripcion());
		ofertaExistente.setDetalles(ofertaPractica.getDetalles());
		
		ofertaRepository.save(ofertaExistente);
	}

	@Override
	public void eliminarOferta(Long id) {
		ofertaRepository.deleteById(id);
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OfertaRepository ofertaRepository;


	@Autowired
	private OfertaServices ofertaServices;
	
	@Autowired
	private CarreraServices carreraServices;
	
	@Autowired
	private EmpresaServices empresaServices;
}