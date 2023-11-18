package com.proyecto.practicas.services.implementations;

import com.proyecto.practicas.models.Usuario;
import com.proyecto.practicas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
/*
    public List<Usuario> getAllUsuarios(Long userId){
        return userRepository.findById(userId);
    }
*/
    public Usuario saveUser(Usuario user) {
        return userRepository.save(user);
    }
    public Usuario updateUser(Long userId, Usuario updatedUser) {

        if (userRepository.existsById(userId)) {
            updatedUser.setId(userId);
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + userId);
        }
    }
    public void deleteUser(Long userId) {
        // Verificar si el usuario existe
        if (userRepository.existsById(userId)) {
            // Eliminar el usuario
            userRepository.deleteById(userId);
        } else {
            // Manejar el caso en que el usuario no existe
            throw new RuntimeException("Usuario no encontrado con ID: " + userId);
        }
    }
}
