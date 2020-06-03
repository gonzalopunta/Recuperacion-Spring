package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @AllArgsConstructor @NoArgsConstructor @Builder @Data @Getter @Setter
public class Usuario {

	@Id @GeneratedValue
	private long id;
	
	private String nombreUsuario;
	private String contrasena;
	private String nombre;
	private boolean admin;
}
