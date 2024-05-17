package com.tecnopracticas.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServicioApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioApiGatewayApplication.class, args);
	}

}
