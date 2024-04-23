package com.registro.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserRegistroApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistroApplication.class, args);
	}

}
