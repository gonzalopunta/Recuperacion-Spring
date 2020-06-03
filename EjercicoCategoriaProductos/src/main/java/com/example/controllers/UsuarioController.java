package com.example.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.CrearUsuarioDTO;
import com.example.DTO.GetUsuarioDTO;
import com.example.DTO.UsuarioDTOConverter;
import com.example.entity.Usuario;
import com.example.services.UsuarioService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	private final UsuarioDTOConverter usuarioDTOConverter;
	
	@PostMapping("/")
	public GetUsuarioDTO nuevoUsuario(@RequestBody CrearUsuarioDTO nuevoUsuario) {
		return usuarioDTOConverter.convertUserToGetUserDto(usuarioService.nuevoUsuario(nuevoUsuario));
	}
	
	@GetMapping("/getUser")
	public GetUsuarioDTO findByNombreUsuario(@RequestParam(value="nombreUsuario") String nombreUsuario) {
		Optional<Usuario> usuarioABuscar;
		usuarioABuscar = usuarioService.findByNombreUsuario(nombreUsuario);
		if(usuarioABuscar.get() != null) {
			return usuarioDTOConverter.convertUserToGetUserDto(usuarioABuscar.get());
		}
		else {
			return new GetUsuarioDTO("", "", false);
		}
	}
	
}
