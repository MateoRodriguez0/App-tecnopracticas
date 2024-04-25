package com.api.email.services;

public interface PlantillasService {

	public String getCorreoVerificarCuenta(String nombre_usuario, String url);
	public String getCorreoCuentaVerificada(String nombre);
	public String getCorreoPostulacionRealizada(String nombre_usuario, String oferta, String empresa);
	public String getCorreoPostulacionAprobada(String nombre_usuario, String oferta, String empresa);
	public String getCorreoPostulacionRechazada(String nombre_usuario, String oferta, String empresa);
	public String getCorreoRestablecerClave(String nombre_usuario, String url);
	public String getCorreoClaveCambiada(String nombre_usuario);
	
}
