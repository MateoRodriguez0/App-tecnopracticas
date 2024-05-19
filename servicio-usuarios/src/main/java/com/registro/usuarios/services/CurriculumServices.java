package com.registro.usuarios.services;


import java.io.IOException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.registro.usuarios.models.HojaVida;
import com.registro.usuarios.models.Usuario;
import com.registro.usuarios.repositories.HojasVidaRepository;

@Service
@Scope("prototype")
public class CurriculumServices {
	   
    @Value("${tecnopracticas.paths.cvs}")
    private String pathsCurriculums;
    
    @Value("${tecnopracticas.paths.ruta_cv}")
    private String rutaCv;
    
    @Autowired
    private HojasVidaRepository hvRepository;
    
    @Autowired
    private CloudStorageServices storageServices;

    @Value("${gcs-resource-test-bucket}")
	private String bucketName;


   
	
	public String guardarCv(MultipartFile multipartFile, UUID id) {
		 if (!multipartFile.getContentType().equals("application/pdf")) {
			 return "TIPO_INVALIDO";
		 }
		String name=pathsCurriculums+"/"+id+".pdf";
		Usuario usuario= Usuario.builder().id(id).build();
		
		if(!hvRepository.existsByEstudiante(usuario)) {
			HojaVida hojaVida= HojaVida.builder().estudiante(usuario)
					.fecha_creacion(Timestamp.from(Instant.now()))
					.ruta(String.format("gs://%s/%s",bucketName, name))
					.build();
			HojaVida hvGuardada=hvRepository.save(hojaVida);
			hvRepository.save(hvGuardada);
		}
		
		try {
			storageServices.uploadObject(name, multipartFile.getResource());
			return "HV_SUBIDA";
		} catch (IOException e) {
			return "ERROR_AL_SUBIR_HV";
		}
	}
	
	
	public Resource buscarCv(UUID id) {
		String rutaCv=hvRepository.getRutaByEstudianteId(id);
		return storageServices.fetchResource(rutaCv);
		
	}
}
