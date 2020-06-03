package com.example.services;

import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.example.entity.Usuario;
import com.example.errors.NotFindUserException;


@Service("userDetailsService")
public class UserDetailsServiceImpl {
	
UsuarioService usuarioServicio;
	
	public UserDetailsServiceImpl(UsuarioService servicio) {
		this.usuarioServicio = servicio;
	}

	public UserDetails loadUserByUsername(String username) throws NotFindUserException {
		
		Optional<Usuario> usuario = usuarioServicio.findByNombreUsuario(username);
		
		UserBuilder userBuilder = null;
		
		if (usuario != null) {
			userBuilder = User.withUsername(usuario.get().getNombreUsuario());
			userBuilder.disabled(false);
			userBuilder.password(usuario.get().getContrasena());
			
			if(usuario.get().isAdmin()) {
				if (usuario.get().isAdmin()) {
					userBuilder.authorities(new SimpleGrantedAuthority("ROLE_ADMIN"));				
				} else {
					userBuilder.authorities(new SimpleGrantedAuthority("ROLE_USER"));				
				}
			}
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
				
		return userBuilder.build();
		
		
	}

}
