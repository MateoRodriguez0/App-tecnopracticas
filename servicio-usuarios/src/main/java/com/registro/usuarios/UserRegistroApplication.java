package com.registro.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@SpringBootApplication
@EnableFeignClients
public class UserRegistroApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRegistroApplication.class, args);
	}
	
	@Bean
	RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
	    return RedisCacheManager.create(connectionFactory);
	}

}
