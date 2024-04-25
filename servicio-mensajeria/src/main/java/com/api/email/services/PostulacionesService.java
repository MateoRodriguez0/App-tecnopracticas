package com.api.email.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.api.email.models.entity.Postulacion;
import com.api.email.repository.UsuariosRespository;

import jakarta.mail.MessagingException;

@Service
public class PostulacionesService {


	public boolean PostulacionRealizada(Postulacion pos) {
		String cuerpo= plantillasService.getCorreoPostulacionRealizada(
				usuariosRespository.getnombreByEmail(pos.getEmail()), pos.getPuesto(), pos.getEmpresa());
		try {
			emailServices.enviarCorreo(pos.getEmail(),
					"Solicitud para el puesto "+pos.getPuesto()+ " en "+ pos.getEmpresa(), cuerpo);
			return true;
		} catch (MailException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean PostulacionAprobada(Postulacion pos) {
		String cuerpo= plantillasService.getCorreoPostulacionAprobada(
				usuariosRespository.getnombreByEmail(pos.getEmail()), pos.getPuesto(), pos.getEmpresa());
		try {
			emailServices.enviarCorreo(pos.getEmail(),
					"Solicitud para el puesto "+pos.getPuesto()+ " en "+ pos.getEmpresa(), cuerpo);
			return true;
		} catch (MailException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}
	
	public boolean PostulacionRechazada(Postulacion pos) {
		String cuerpo= plantillasService.getCorreoPostulacionRechazada(
				usuariosRespository.getnombreByEmail(pos.getEmail()), pos.getPuesto(), pos.getEmpresa());
		try {
			emailServices.enviarCorreo(pos.getEmail(),
					"Solicitud para el puesto "+pos.getPuesto()+ " en "+ pos.getEmpresa(), cuerpo);
			return true;
		} catch (MailException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Autowired
	private EmailServices emailServices;
	
	@Autowired
	private PlantillasService plantillasService;
	
	@Autowired
	private UsuariosRespository usuariosRespository;
}
