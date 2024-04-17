package com.tecnopracticas.gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteTecnopracticas {

	@Bean
	RouteLocator routesTecnopracticas(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.build();
	}
}
