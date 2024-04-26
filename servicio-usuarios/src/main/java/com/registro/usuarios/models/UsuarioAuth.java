package com.registro.usuarios.models;

import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioAuth {

	public UsuarioAuth(Usuario usuario) {
		if(usuario!=null) {
			this.correo=usuario.getCorreo();
			this.activo=usuario.isActivo();
			this.roles=usuario.getRoles();
			this.id=usuario.getId();
			this.password=usuario.getPassword();
		}
		
	}
	private UUID id;
    private String correo;
    private boolean activo;
    private String password;
    private List<Rol> roles;
}
