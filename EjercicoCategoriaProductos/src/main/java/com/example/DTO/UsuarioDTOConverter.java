package com.example.DTO;

import org.springframework.stereotype.Component;

import com.example.entity.Usuario;


@Component
public class UsuarioDTOConverter {

	public GetUsuarioDTO convertUserToGetUserDto(Usuario usuario) {
		return GetUsuarioDTO.builder()
				.nombreUsuario(usuario.getNombreUsuario())
				.nombre(usuario.getNombre())
				.admin(usuario.isAdmin()).build();
	}
	
}
