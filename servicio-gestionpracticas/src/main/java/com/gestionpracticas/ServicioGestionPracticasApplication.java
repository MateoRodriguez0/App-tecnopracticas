package com.gestionpracticas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicioGestionPracticasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioGestionPracticasApplication.class, args);
	}

}
