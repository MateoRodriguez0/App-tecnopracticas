package com.proyecto.practicas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiTecnopracticasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTecnopracticasApplication.class, args);
	}

}
