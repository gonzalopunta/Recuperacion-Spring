package com.example.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class EditarProductosDTO {

	private String nombre;
	private String descripcion;
	private String precio;
}