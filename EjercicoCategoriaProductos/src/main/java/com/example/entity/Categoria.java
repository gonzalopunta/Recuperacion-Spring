package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

	@Id @GeneratedValue
	private Long id;
	private String nombre;
	private String imagen;
	
	@ManyToOne
	private Productos productos;
	
	
}
