package com.api.email.services.implementations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.api.email.services.PlantillasService;

@Service
@Scope("prototype")
@Primary
public class PlantillaServiceImpl implements PlantillasService {



	@Override
	public String getCorreoVerificarCuenta(String nombre_usuario, String url) {
		
		return "<div\r\n"
				+ "      style=\"\r\n"
				+ "        max-width: 800px;\r\n"
				+ "        margin: 30px auto;\r\n"
				+ "        padding: 40px;\r\n"
				+ "        background-color: #ffffff;\r\n"
				+ "        border: 1px solid #ddd;\r\n"
				+ "        text-align: left;\r\n"
				+ "        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);\r\n"
				+ "        border-radius: 5px;\r\n"
				+ "      \"\r\n"
				+ "    >\r\n"
				+ "      <img\r\n"
				+ "        src="+logoRecurso+""
				+ "        alt=\"Logo\"\r\n"
				+ "        style=\"height: 150px; width: 230px; margin: 0 auto 20px; display: block\"\r\n"
				+ "      />\r\n"
				+ "      <h1 style=\"font-weight: bold\">Estimado/a "+nombre_usuario+",</h1>\r\n"
				+ "      <p>\r\n"
				+ "        Para completar la configuración de tu cuenta y comenzar a disfrutar de\r\n"
				+ "        los beneficios de TecnoPracticas, necesitamos confirmar que tenemos tu\r\n"
				+ "        dirección de correo electrónico correcta.\r\n"
				+ "      </p>\r\n"
				+ "      <a\r\n"
				+ "        href="+url+""
				+ "        style=\"\r\n"
				+ "        display: inline-block;\r\n"
				+ "        padding: 8px 16px; \r\n"
				+ "        background-color: #00466a;\r\n"
				+ "        color: white;\r\n"
				+ "        border-radius: 4px; \r\n"
				+ "        font-weight: bold;\r\n"
				+ "        margin-bottom: 4px;\r\n"
				+ "        text-decoration: none;\"\r\n"
				+ "        >Verificar correo electrónico</a\r\n"
				+ "      >\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Si tienes alguna pregunta o necesitas asistencia, no dudes en ponerte en\r\n"
				+ "        contacto con nuestro equipo de soporte.\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Atentamente, Equipo de asistencia de TecnoPracticas\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Es un correo generado automáticamente. Las respuestas enviadas a esta\r\n"
				+ "        dirección de correo no se revisan.\r\n"
				+ "      </p>\r\n"
				+ "    </div>\r\n"
				+ "";
	}





	@Override
	public String getCorreoCuentaVerificada(String nombre) {
		// TODO Auto-generated method stub
		return " <div\r\n"
				+ "      style=\"\r\n"
				+ "        max-width: 800px;\r\n"
				+ "        margin: 30px auto;\r\n"
				+ "        padding: 40px; \r\n"
				+ "        background-color: #ffffff;\r\n"
				+ "        border: 1px solid #ddd;\r\n"
				+ "        text-align: left; \r\n"
				+ "        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);\r\n"
				+ "        border-radius: 5px;\r\n"
				+ "      \"\r\n"
				+ "    >\r\n"
				+ "      <img\r\n"
				+ "        src="+logoRecurso+""
				+ "        alt=\"Logo\"\r\n"
				+ "        style=\"height: 150px; width: 230px; margin: 0 auto 20px; display: block\"\r\n"
				+ "      />\r\n"
				+ "      <h1 style=\"font-weight: bold;\">Estimado/a "+nombre+",</h1>\r\n"
				+ "      <p>\r\n"
				+ "        Nos complace informarte que tu cuenta en TecnoPracticas ha sido verificada con éxito. ¡Felicidades!\r\n"
				+ "      </p>\r\n"
				+ "      <p>\r\n"
				+ "        La verificación de tu cuenta te proporciona acceso a funciones\r\n"
				+ "        adicionales y garantiza la autenticidad y seguridad de tu perfil. Ahora\r\n"
				+ "        podrás disfrutar plenamente de todos los beneficios que nuestra\r\n"
				+ "        plataforma tiene para ofrecer.\r\n"
				+ "      </p>\r\n"
				+ "      <p>\r\n"
				+ "        Si tienes alguna pregunta o necesitas asistencia adicional, no dudes en\r\n"
				+ "        ponerte en contacto con nuestro equipo de soporte. Estamos aquí para\r\n"
				+ "        ayudarte en todo momento.\r\n"
				+ "      </p>\r\n"
				+ "\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Atentamente,\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Equipo de asistencia TecnoPracticas\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Es un correo generado automáticamente. Las respuestas enviadas a esta\r\n"
				+ "        dirección de correo no se revisan.\r\n"
				+ "      </p>\r\n"
				+ "    </div>\r\n"
				+ "";
	}





	@Override
	public String getCorreoPostulacionRealizada(String nombre_usuario, String oferta, String empresa) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public String getCorreoPostulacionAprobada(String nombre_usuario, String oferta, String empresa) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public String getCorreoPostulacionRechazada(String nombre_usuario, String oferta, String empresa) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public String getOfertaPublicada() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public String getCorreoRestablecerClave(String nombre_usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Value("${tecnopracticas.urls.logo}")
	private String logoRecurso;



	@Override
	public String getCorreoClaveCambiada(String nombre_usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
