package com.proyecto.practicas.services;


import com.proyecto.practicas.models.Usuario;

import java.util.List;

public interface UserService {
	
	Usuario updateUser(Long userId, Usuario updatedUser);
	
	void deleteUser(Long userId);

	List<Usuario> getAllUsuarios();

    Boolean ExistUserByEmail(String email);
    
    Usuario getUsuarioByEmail(String email);

    void registrarUsuario(Usuario usuario);

}
