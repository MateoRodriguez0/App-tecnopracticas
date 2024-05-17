package com.serviciopostulacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicioPostulacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioPostulacionApplication.class, args);
	}

}
