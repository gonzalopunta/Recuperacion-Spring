package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class Productos {

	@Id @GeneratedValue
	private Long id;
	private String nombre;
	private String descripcion;
	private Long precio;
	
	@ManyToOne
	Categoria categoria;
	
}
