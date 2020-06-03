package com.example.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.CrearUsuarioDTO;
import com.example.DTO.GetUsuarioDTO;
import com.example.DTO.UsuarioDTOConverter;
import com.example.services.UsuarioService;


@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	private final UsuarioService usuarioService = new UsuarioService();
	private final UsuarioDTOConverter usuarioDTOConverter = new UsuarioDTOConverter();
	
	@PostMapping("/")
	public GetUsuarioDTO nuevoUsuario(@RequestBody CrearUsuarioDTO nuevoUsuario) {
		return usuarioDTOConverter.convertUserToGetUserDto(usuarioService.nuevoUsuario(nuevoUsuario));
	}
	
	
}
