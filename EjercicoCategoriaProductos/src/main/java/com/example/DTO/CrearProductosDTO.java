package com.example.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.entity.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor

public class CrearProductosDTO {

	@Id @GeneratedValue
	private Long id;
	private String nombre;
	private String descripcion;
	private Long precio;
	private Long categoriaId;

	@ManyToOne
	Categoria categoria;
}
