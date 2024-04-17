package com.api.email.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@Scope("prototype")
public class EmailServices {

	
	public boolean enviarCorreo(String email_to,String asunto, String cuerpo)throws MailException, MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		String emailServer=environment.getProperty("spring.mail.username");
		
		helper.setFrom(emailServer);
		helper.setTo(email_to);
		helper.setSubject(asunto);
		helper.setText(cuerpo,true);
		
		javaMailSender.send(message);
		return true;
		
		
	}
	
	
	
	
	
	
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private JavaMailSender javaMailSender;
}
