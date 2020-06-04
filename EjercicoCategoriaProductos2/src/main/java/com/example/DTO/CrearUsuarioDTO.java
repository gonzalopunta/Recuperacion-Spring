package com.example.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CrearUsuarioDTO {

	@Id @GeneratedValue
	private long id;
	
	private String nombreUsuario;
	private String contrasena;
	private String contrasena2;
	private String nombre;
	private boolean admin;
}
