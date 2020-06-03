package com.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class GetUsuarioDTO {

	private String nombreUsuario;
	private String nombre;
	private boolean admin;
}
