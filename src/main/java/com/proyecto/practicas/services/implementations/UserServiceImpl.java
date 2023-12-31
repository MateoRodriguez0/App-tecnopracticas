package com.proyecto.practicas.services.implementations;

import com.proyecto.practicas.models.Usuario;
import com.proyecto.practicas.repositories.UserRepository;
import com.proyecto.practicas.services.UserService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
	@Override
    public Usuario updateUser(Long userId, Usuario updatedUser) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public Boolean ExistUserByEmail(String email) {
    	
       return userRepository.existsByEmail(email);
    }


  
	@Override
	public Usuario getUsuarioByEmail(String email) {
		
		
		return userRepository
				.findByEmail(email)
				.orElse(null);
	}
	
	
	
	

	@Override
	public void registrarUsuario(Usuario usuario) {
		
		usuario.setEnable(false);
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		userRepository.save(usuario);
	}

	@Override
	@Transactional
	public void activarCuenta(String email) {
		
		Usuario usuario = getUsuarioByEmail(email);
		usuario.setEnable(true);
		usuario.setPasswordValid("PasswordValid.123");
		
		userRepository.save(usuario);
	}
	   	
	@Override
	public String getnameByEmail(String email) {
		
		return getUsuarioByEmail(email).getNombre();
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;



}
