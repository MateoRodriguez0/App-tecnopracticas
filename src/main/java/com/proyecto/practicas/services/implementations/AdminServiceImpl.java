package com.proyecto.practicas.services.implementations;

import com.proyecto.practicas.repositories.OfertaRepository;
import com.proyecto.practicas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.practicas.models.OfertaPractica;
import com.proyecto.practicas.models.Usuario;
import com.proyecto.practicas.services.AdminServices;

@Service
public class AdminServiceImpl implements AdminServices {

	@Override
	public void RegistrarAdmin(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publicarOferta(OfertaPractica ofertaPractica) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarOferta(OfertaPractica ofertaPractica) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarOferta(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Autowired
	private OfertaRepository ofertaRepository;

	@Override
	public void publicarOferta(OfertaPractica ofertaPractica){
		ofertaRepository.save(ofertaPractica);
	}

	@Override
	public void actualizarOferta(OfertaPractica ofertaPractica){
	}

	@Override
	public void eliminarOferta(Long id) {
		}
}
