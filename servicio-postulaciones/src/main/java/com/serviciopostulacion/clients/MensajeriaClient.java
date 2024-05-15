package com.serviciopostulacion.clients;

import com.serviciopostulacion.model.Postulacion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "mensajeriaClient",url = "http://localhost:10455")
public interface MensajeriaClient {
	/*
	@PostMapping(value = "/postulaciones/rechazada")
	public ResponseEntity<Boolean> postulacionRechazada(@RequestBody Postulacion postulacion) {
		return ResponseEntity.ok(postulacion.PostulacionRechazada(postulacion));
	}

	@PostMapping(value = "/postulaciones/aprobada")
	public ResponseEntity<Boolean> postulacionAprobada(@RequestBody Postulacion postulacion){
		return ResponseEntity.ok(postulaciones.PostulacionAprobada(postulacion));
	}

	@PostMapping(value = "/postulaciones/creada")
	public ResponseEntity<Boolean> PostulacionCreada(@RequestBody Postulacion postulacion){
		return ResponseEntity.ok(postulaciones.PostulacionRealizada(postulacion));
	}

	@PostMapping(value = "/postulaciones/revision")
	public ResponseEntity<Boolean> PostulacionEnRevision(@RequestBody Postulacion postulacion){
		return ResponseEntity.ok(postulaciones.PostulacionEnRevision(postulacion));
	}*/
}

