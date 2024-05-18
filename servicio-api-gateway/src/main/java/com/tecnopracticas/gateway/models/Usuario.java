package com.tecnopracticas.gateway.models;

import lombok.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Data
@NoArgsConstructor
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private UUID id;
    private String correo;
    private boolean activo;
    private String password;
    private List<Rol> roles;
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
				.map(rol ->new SimpleGrantedAuthority(rol.getNombre())).toList();
	}
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return correo;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return activo;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
}