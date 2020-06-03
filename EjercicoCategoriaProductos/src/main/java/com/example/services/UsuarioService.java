package com.example.services;

import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.DTO.CrearUsuarioDTO;
import com.example.entity.Usuario;
import com.example.errors.NewUserWithDifferentPasswordsException;
import com.example.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseService<Usuario, Long, UsuarioRepository>{

	private final PasswordEncoder passwordEncoder;
	
	//Esta funcion lo que hace es buscar un usuario por su nombre de usuario si existe
	public Optional<Usuario> findByUsername(String nombreUsuario){
		return this.repositorio.findByUsername(nombreUsuario);
	}
	
	//Creamos un nuevo usuario y si ya existe ese usuario se lo indicamos al usuario
	//También lanzamos la excepcion de que las contraseñas no coinciden
	public Usuario nuevoUsuario(CrearUsuarioDTO nuevoUsuario) {
		if (nuevoUsuario.getContrasena().compareTo(nuevoUsuario.getContrasena2())==0) {
			Usuario usuario = Usuario.builder().nombreUsuario(nuevoUsuario.getNombreUsuario())
								.contrasena(passwordEncoder.encode(nuevoUsuario.getContrasena()))
								.admin(nuevoUsuario.isAdmin()).build();
			try {
				return save(usuario);
			} catch (DataIntegrityViolationException ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ese usuario ya existe");
			}
		}
		else {
			throw new NewUserWithDifferentPasswordsException();
		}
	}
}
