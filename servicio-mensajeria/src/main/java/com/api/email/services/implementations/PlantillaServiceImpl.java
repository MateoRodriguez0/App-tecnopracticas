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
				+ "        dirección de correo electrónico correcta. \r\n"
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
				+"   	 <p>Este enlace es valido por 10 minutos.</p> "
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
				+ "       background-color: #f7f7f7;\r\n"
				+ "        font-family: Roboto, sans-serif;\r\n"
				+ "        margin: 0;\r\n"
				+ "        padding: 0;\r\n"
				+ "        max-width: 800px;\r\n"
				+ "        margin: 30px auto;\r\n"
				+ "        padding: 40px; \r\n"
				+ "        background-color: #ffffff;\r\n"
				+ "        border: 1px solid #ddd;\r\n"
				+ "        text-align: left; \r\n"
				+ "        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);\r\n"
				+ "        border-radius: 5px;"
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
		return  "<div\r\n"
				+ "      style=\"\r\n"
				+ "		   background-color: #f7f7f7;\r\n"
				+ "        font-family: Roboto, sans-serif;\r\n"
				+ "        margin: 0;\r\n"
				+ "        padding: 0;\r\n"
				+ "        max-width: 800px;\r\n"
				+ "        margin: 30px auto;\r\n"
				+ "        padding: 40px; /* Aumentado el padding para más espacio */\r\n"
				+ "        background-color: #ffffff;\r\n"
				+ "        border: 1px solid #ddd;\r\n"
				+ "        text-align: left; /* Alinea el texto a la izquierda */\r\n"
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
				+ "        Queremos agradecerte por haber enviado tu postulación para el puesto de\r\n"
				+ "        <strong>"+oferta+"</strong> en <strong>"+empresa+"</strong>. Confirmamos la recepción de tu\r\n"
				+ "        solicitud y queremos asegurarte que tu aplicación será revisada con\r\n"
				+ "        atención por nuestro equipo de selección. Valoramos tu interés en formar\r\n"
				+ "        parte de nuestro equipo y estamos emocionados de considerarte para este\r\n"
				+ "        puesto.\r\n"
				+ "      </p>\r\n"
				+ "      <p>\r\n"
				+ "        Si tu perfil coincide con los requisitos y necesidades de la posición,\r\n"
				+ "        nos pondremos en contacto contigo para programar una entrevista o para\r\n"
				+ "        proporcionarte más información sobre el proceso de selección.\r\n"
				+ "      </p>\r\n"
				+ "      <p>\r\n"
				+ "        ¡Te deseamos mucho éxito en este proceso y esperamos tener la\r\n"
				+ "        oportunidad de conocerte mejor!\r\n"
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
				+ "    </div>";
	}





	@Override
	public String getCorreoPostulacionAprobada(String nombre_usuario, String oferta, String empresa) {
		// TODO Auto-generated method stub
		return "<div\r\n"
				+ "      style=\"\r\n"
				+ "        background-color: #f7f7f7;\r\n"
				+ "        font-family: Roboto, sans-serif;\r\n"
				+ "        margin: 0;\r\n"
				+ "        padding: 0;\r\n"
				+ "        max-width: 800px;\r\n"
				+ "        margin: 30px auto;\r\n"
				+ "        padding: 40px; /* Aumentado el padding para más espacio */\r\n"
				+ "        background-color: #ffffff;\r\n"
				+ "        border: 1px solid #ddd;\r\n"
				+ "        text-align: left; /* Alinea el texto a la izquierda */\r\n"
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
				+ "		 <p>\r\n"
				+ "        Espero que este mensaje te encuentre bien. Nos complace informarte que\r\n"
				+ "        tu solicitud para el puesto de <strong>"+oferta+"</strong> en <strong>"+empresa+"</strong> \r\n"
				+ "        ha sido revisada y aprobada.\r\n"
				+ "      </p>\r\n"
				+ "      <p>\r\n"
				+ "        Felicidades!, has sido seleccionado/a para avanzar en el proceso de selección! Tu\r\n"
				+ "        experiencia y habilidades destacaron entre los demás\r\n"
				+ "        candidatos, y creemos firmemente que contribuirás de manera\r\n"
				+ "        significativa a nuestro equipo.\r\n"
				+ "      </p>\r\n"
				+ "      <p>\r\n"
				+ "        El equipo de "+empresa+" se encuentra emocionado\r\n"
				+ "        y ansiosos por trabajar contigo.\r\n"
				+ "      </p>\r\n"
				+ "      <p>¡Felicidades nuevamente y pronto nos pondremos en contacto contigo\r\n"
				+ "			para programar una entrevista o para proporcionarte más información\r\n"
				+ "			sobre el proceso de selección!</p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 10px\">\r\n"
				+ "        Atentamente,\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 10px\">\r\n"
				+ "        Equipo de asistencia TecnoPracticas\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 10px\">\r\n"
				+ "        Es un correo generado automáticamente. Las respuestas enviadas a esta\r\n"
				+ "        dirección de correo no se revisan.\r\n"
				+ "      </p>\r\n"
				+ "    </div>";
	}





	@Override
	public String getCorreoPostulacionRechazada(String nombre_usuario, String oferta, String empresa) {
		// TODO Auto-generated method stub
		return "    <div\r\n"
				+ "      style=\"\r\n"
				+ "       max-width: 800px;\r\n"
				+ "        background-color: #f7f7f7;\r\n"
				+ "       font-family: Roboto, sans-serif;\r\n"
				+ "        margin: 0;\r\n"
				+ "        padding: 0;\r\n"
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
				+ "        Espero que este mensaje te encuentre bien. Queremos expresarte nuestro\r\n"
				+ "        agradecimiento por tu interés en el puesto de <strong>"+oferta+"</strong> en\r\n"
				+ "        <strong>"+empresa+"</strong>. Valoramos sinceramente el tiempo y\r\n"
				+ "        esfuerzo que invertiste en el proceso de selección.\r\n"
				+ "      </p>\r\n"
				+ "      <p>\r\n"
				+ "        Después de una cuidadosa evaluación de todas las aplicaciones recibidas,\r\n"
				+ "        lamentamos informarte que, en esta ocasión, hemos decidido avanzar con\r\n"
				+ "        otros candidatos que mejor se ajustan a nuestras necesidades y\r\n"
				+ "        requisitos específicos para el puesto.\r\n"
				+ "      </p>\r\n"
				+ "      <p>\r\n"
				+ "        Te deseamos mucho éxito en tus futuros esfuerzos profesionales y te\r\n"
				+ "        agradecemos nuevamente por tu interés en unirte a nuestro equipo.\r\n"
				+ "      </p>\r\n"
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
				+ "    </div>";
	}

	@Override
	public String getCorreoRestablecerClave(String nombre_usuario, String url) {
		// TODO Auto-generated method stub
		return " <div\r\n"
				+ "      style=\"\r\n"
				+ "        background-color: #f7f7f7;\r\n"
				+ "        font-family: Roboto, sans-serif;\r\n"
				+ "        margin: 0;\r\n"
				+ "        padding: 0;\r\n"
				+ "        max-width: 800px;\r\n"
				+ "        margin: 30px auto;\r\n"
				+ "        padding: 40px; /* Aumentado el padding para más espacio */\r\n"
				+ "        background-color: #ffffff;\r\n"
				+ "        border: 1px solid #ddd;\r\n"
				+ "        text-align: left; /* Alinea el texto a la izquierda */\r\n"
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
				+ "        Espero que te encuentres bien. Hemos recibido una solicitud para\r\n"
				+ "        restablecer la contraseña de tu cuenta en TecnoPracticas. Para ayudarte\r\n"
				+ "        con este proceso, haz clic en el siguiente enlace para restablecer tu\r\n"
				+ "        contraseña.\r\n"
				+ "      </p>\r\n"
				+ "      <a\r\n"
				+ "        href="+url+""
				+ "        style=\"\r\n"
				+ "          display: inline-block;\r\n"
				+ "          padding: 8px 16px;\r\n"
				+ "          background-color: #00466a;\r\n"
				+ "          color: white;\r\n"
				+ "          border-radius: 4px;\r\n"
				+ "          font-weight: bold;\r\n"
				+ "          margin-bottom: 4px;\r\n"
				+ "          text-decoration: none;\r\n"
				+ "        \"\r\n"
				+ "        >Restablece tu contraseña</a\r\n"
				+ "      >\r\n"
				+"   	 <p>Este enlace es valido por 10 minutos.</p> "
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Si no has solicitado este cambio o no reconoces esta solicitud, por\r\n"
				+ "        favor ignora este correo electrónico. Tu cuenta seguirá segura y\r\n"
				+ "        protegida.\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Por motivos de seguridad, te recomendamos que elijas una contraseña\r\n"
				+ "        segura y única que no hayas utilizado anteriormente en ningún otro\r\n"
				+ "        servicio en línea.\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Si necesitas ayuda adicional o tienes alguna pregunta, no dudes en\r\n"
				+ "        contactar con nosotros. Estamos aquí para ayudarte.\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Atentamente,\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 10px\">\r\n"
				+ "        Equipo de asistencia TecnoPracticas\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 8px\">\r\n"
				+ "        Es un correo generado automáticamente. Las respuestas enviadas a esta\r\n"
				+ "        dirección de correo no se revisan.\r\n"
				+ "      </p>\r\n"
				+ "    </div>";
	}
	
	@Override
	public String getCorreoPostulacionEnRevision(String nombre_usuario, String oferta, String empresa) {
		// TODO Auto-generated method stub
		return "<div class=\"container\">\r\n"
				+ "      <style>\r\n"
				+ "        body {\r\n"
				+ "          background-color: #f7f7f7;\r\n"
				+ "          font-family: \"Roboto\", sans-serif;\r\n"
				+ "          margin: 0;\r\n"
				+ "          padding: 0;\r\n"
				+ "        }\r\n"
				+ "        .container {\r\n"
				+ "          max-width: 800px;\r\n"
				+ "          margin: 30px auto;\r\n"
				+ "          padding: 40px; /* Aumentado el padding para más espacio */\r\n"
				+ "          background-color: #ffffff;\r\n"
				+ "          border: 1px solid #ddd;\r\n"
				+ "          text-align: left; /* Alinea el texto a la izquierda */\r\n"
				+ "          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);\r\n"
				+ "          border-radius: 5px;\r\n"
				+ "        }\r\n"
				+ "  \r\n"
				+ "        .footer {\r\n"
				+ "          font-size: 12px;\r\n"
				+ "          color: #777777;\r\n"
				+ "          margin-top: 20px;\r\n"
				+ "        }\r\n"
				+ "        .header {\r\n"
				+ "          font-weight: bold; /* Hace el título en negritas */\r\n"
				+ "        }\r\n"
				+ "        .btn-verificar-correo {\r\n"
				+ "          display: inline-block;\r\n"
				+ "          padding: 8px 16px; /* Ajusta el padding según lo necesites */\r\n"
				+ "          background-color: #00466a;\r\n"
				+ "          color: white;\r\n"
				+ "          border-radius: 4px; /* Ajusta el radio según lo necesites */\r\n"
				+ "          font-weight: bold;\r\n"
				+ "          margin-bottom: 4px; /* Ajusta el margen inferior según lo necesites */\r\n"
				+ "          text-decoration: none; /* Elimina el subrayado del enlace */\r\n"
				+ "        }\r\n"
				+ "      </style>\r\n"
				+ "      <img\r\n"
				+ "        src="+logoRecurso+""
				+ "        alt=Logo"
				+ "        style=\"height: 150px; width: 230px; margin: 0 auto 20px; display: block\"\r\n"
				+ "      />\r\n"
				+ "      <h1 class=\"header\">Estimado/a "+nombre_usuario+",</h1>\r\n"
				+ "      <p>\r\n"
				+ "         Nos complace informarte que tu solicitud para el puesto de"
				+ "        <strong>"+oferta+"</strong> en <strong>"+empresa+"</strong> "
				+ "      se encuentra en proceso de revisión."
				+ "      </p>\r\n"
				+ "      <p>\r\n"
				+ "       <p>\r\n"
				+ "        Si tu perfil coincide con los requisitos y necesidades de la posición,\r\n"
				+ "        pronto te lo haremos saber para proporcionarte más información "
				+ "        sobre el proceso de selección."
				+ "      </p>"
				+ "      <p>Le pedimos que nos tenga paciencia, ya que a veces el proceso de revisión se puede tardar un poco.\r\n"
				+ "      </p>"
				+ "      <p class=\"footer\">Atentamente,</p>\r\n"
				+ "      <p class=\"footer\">Equipo de asistencia TecnoPracticas</p>\r\n"
				+ "      <p class=\"footer\">\r\n"
				+ "        Es un correo generado automáticamente. Las respuestas enviadas a esta\r\n"
				+ "        dirección de correo no se revisan.\r\n"
				+ "      </p>\r\n"
				+ "    </div>";
	}
	


	@Override
	public String getCorreoClaveCambiada(String nombre_usuario) {
		// TODO Auto-generated method stub
		return "    <div\r\n"
				+ "      style=\"\r\n"
				+ "        background-color: #f7f7f7;\r\n"
				+ "        font-family: Roboto, sans-serif;\r\n"
				+ "        margin: 0;\r\n"
				+ "        padding: 0;\r\n"
				+ "        max-width: 800px;\r\n"
				+ "        margin: 30px auto;\r\n"
				+ "        padding: 40px; /* Aumentado el padding para más espacio */\r\n"
				+ "        background-color: #ffffff;\r\n"
				+ "        border: 1px solid #ddd;\r\n"
				+ "        text-align: left; /* Alinea el texto a la izquierda */\r\n"
				+ "        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);\r\n"
				+ "        border-radius: 5px;\r\n"
				+ "      \"\r\n"
				+ "    >\r\n"
				+ "      <img\r\n"
				+ "        src=\"https://raw.githubusercontent.com/JeysonM11/plantilla_correos/main/logos/LOGO_NUEVO.png\"\r\n"
				+ "        alt=\"Logo\"\r\n"
				+ "        style=\"height: 150px; width: 230px; margin: 0 auto 20px; display: block\"\r\n"
				+ "      />\r\n"
				+ "      <h1 style=\"font-weight: bold\">Estimado/a "+nombre_usuario+",</h1>\r\n"
				+ "      <p>\r\n"
				+ "        Se cambio tu contraseña, tal cual como lo pediste. 	\r\n"
				+ "      </p>\r\n"
				+ "      \r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Si no has solicitado este cambio o no reconoces esta solicitud,\r\n"
				+ "        te recomendamos restablecer nuevamente tu contraseña y Cerrar sesión en todos los dispositivos.\r\n"
				+ "      </p>\r\n"
				+ "\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 20px\">\r\n"
				+ "        Si necesitas ayuda adicional o tienes alguna pregunta, no dudes en\r\n"
				+ "        contactar con nosotros. Estamos aquí para ayudarte.\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 10px\">\r\n"
				+ "        Atentamente, Equipo de asistencia TecnoPracticas\r\n"
				+ "      </p>\r\n"
				+ "      <p style=\"font-size: 12px; color: #777777; margin-top: 8px\">\r\n"
				+ "        Es un correo generado automáticamente. Las respuestas enviadas a esta\r\n"
				+ "        dirección de correo no se revisan.\r\n"
				+ "      </p>\r\n"
				+ "    </div>";
	}



	@Value("${tecnopracticas.urls.logo}")
	private String logoRecurso;

	
}
