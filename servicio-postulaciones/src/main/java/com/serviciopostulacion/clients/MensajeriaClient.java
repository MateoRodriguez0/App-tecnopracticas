package com.serviciopostulacion.clients;

import com.serviciopostulacion.model.PostulacionEmail;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mensajeriaClient",url = "http://localhost:10455")
public interface MensajeriaClient {
	
	@PostMapping(value = "/postulaciones/rechazada")
	public ResponseEntity<Boolean> postulacionRechazada(@RequestBody PostulacionEmail postulacion);

	@PostMapping(value = "/postulaciones/aprobada")
	public ResponseEntity<Boolean> postulacionAprobada(@RequestBody PostulacionEmail postulacion);

	@PostMapping(value = "/postulaciones/creada")
	public ResponseEntity<Boolean> PostulacionCreada(@RequestBody PostulacionEmail postulacion);
	
	@PostMapping(value = "/postulaciones/revision")
	public ResponseEntity<Boolean> PostulacionEnRevision(@RequestBody PostulacionEmail postulacion);
}

