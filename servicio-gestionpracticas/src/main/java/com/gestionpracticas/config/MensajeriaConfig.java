package com.gestionpracticas.config;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "mensajeriaGestionPracticas",url = "http://localhost:10455")
public interface MensajeriaConfig {
}
