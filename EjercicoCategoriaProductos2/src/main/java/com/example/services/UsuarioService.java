package com.example.services;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.DTO.CrearUsuarioDTO;
import com.example.entity.Usuario;
import com.example.errors.NewUserWithDifferentPasswordsException;
import com.example.errors.NotFindUserException;
import com.example.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseService<Usuario, Long, UsuarioRepository>{

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	//Esta funcion lo que hace es buscar un usuario por su nombre de usuario si existe
	public Optional<Usuario> findByNombreUsuario(String nombreUsuario){
		return this.repositorio.findByNombreUsuario(nombreUsuario);
	}
	
	//Creamos un nuevo usuario y si ya existe ese usuario se lo indicamos al usuario
	//También lanzamos la excepcion de que las contraseñas no coinciden
	public Usuario nuevoUsuario(CrearUsuarioDTO nuevoUsuario) {
		if (nuevoUsuario.getContrasena().compareTo(nuevoUsuario.getContrasena2())==0) {
			Usuario usuario = Usuario.builder().nombreUsuario(nuevoUsuario.getNombreUsuario())
								.contrasena(nuevoUsuario.getContrasena())
								.nombre(nuevoUsuario.getNombre())
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
