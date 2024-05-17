package com.serviciopostulacion.services;

import com.serviciopostulacion.model.EstadoPostulacion;
import com.serviciopostulacion.model.Oferta;
import com.serviciopostulacion.model.Postulacion;
import com.serviciopostulacion.repositories.PostulacionRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostulacionService {
    private final PostulacionRepository postulacionRepository;

    @Autowired
    public PostulacionService(PostulacionRepository postulacionRepository) {
        this.postulacionRepository = postulacionRepository;
    }

    public List<Postulacion> listarPostulaciones() {
        return postulacionRepository.findAll();
    }

    public Postulacion obtenerPostulacionPorId(UUID id) {
        return postulacionRepository.findById(id).orElse(null);
    }

    public Postulacion crearPostulacion(Postulacion postulacion) {
        return postulacionRepository.save(postulacion);
    }

    public Postulacion actualizarPostulacion(Postulacion postulacion) {
        return postulacionRepository.save(postulacion);
    }

    public void eliminarPostulacion(UUID id) {
        postulacionRepository.deleteById(id);
    }

    public Postulacion aprobarPostulacion(UUID id) {
        Optional<Postulacion> postulacionOptional = postulacionRepository.findById(id);
        if (postulacionOptional.isPresent()) {
            Postulacion postulacion = postulacionOptional.get();
            postulacion.setEstadoPostulacion(EstadoPostulacion.SELECCIONADA);
            return postulacionRepository.save(postulacion);
        }
        return null;
    }

    public Postulacion rechazarPostulacion(UUID id) {
        Optional<Postulacion> postulacionOptional = postulacionRepository.findById(id);
        if (postulacionOptional.isPresent()) {
            Postulacion postulacion = postulacionOptional.get();
            postulacion.setEstadoPostulacion(EstadoPostulacion.NO_SELECCIONADA);
            return postulacionRepository.save(postulacion);
        }
        return null;
    }

    public Postulacion cambiarEstadoPostulacion(UUID id, EstadoPostulacion nuevoEstado) {
        Optional<Postulacion> postulacionOptional = postulacionRepository.findById(id);
        if (postulacionOptional.isPresent()) {
            Postulacion postulacion = postulacionOptional.get();
            postulacion.setEstadoPostulacion(nuevoEstado);
            return postulacionRepository.save(postulacion);
        }
        return null;
    }

    //Listar postulaciones de un usurio
    public Optional<Postulacion> getPostulacionesById(UUID Id) {
        return postulacionRepository.findById(Id);
    }


}

