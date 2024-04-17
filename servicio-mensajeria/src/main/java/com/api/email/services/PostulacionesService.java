package com.api.email.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.api.email.models.entity.Postulacion;

import jakarta.mail.MessagingException;

@Service
public class PostulacionesService {


	public boolean PostulacionRealizada(Postulacion pos) {
		String cuerpo= plantillasService.getCorreoPostulacionRealizada(
				pos.getNombre_usuario(), pos.getNombre_oferta(), pos.getEmpresa());
		try {
			emailServices.enviarCorreo(pos.getEmail_usuario(),
					"Postulación a "+pos.getNombre_oferta()+" - "+pos.getNombre_usuario(), cuerpo);
			return true;
		} catch (MailException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean PostulacionAprobada(Postulacion pos) {
		String cuerpo= plantillasService.getCorreoPostulacionAprobada(
				pos.getNombre_usuario(), pos.getNombre_oferta(), pos.getEmpresa());
		try {
			emailServices.enviarCorreo(pos.getEmail_usuario(),
					"Su postulación a "+pos.getNombre_oferta()+" ha sido aprobada", cuerpo);
			return true;
		} catch (MailException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}
	
	public boolean PostulacionRechazada(Postulacion pos) {
		String cuerpo= plantillasService.getCorreoPostulacionRechazada(
				pos.getNombre_usuario(), pos.getNombre_oferta(), pos.getEmpresa());
	
		try {
			emailServices.enviarCorreo(pos.getEmail_usuario(),
					"Su postulación a "+pos.getNombre_oferta()+" no ha sido seleccionada", cuerpo);
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
}
