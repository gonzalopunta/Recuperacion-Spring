package com.example.services;
import org.springframework.stereotype.Service;

import com.example.DTO.CrearCategoriaDTO;
import com.example.entity.Categoria;
import com.example.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService extends BaseService<Categoria, Long, CategoriaRepository>{
	
	
	public Categoria insertarCategoria(CrearCategoriaDTO nuevaCategoriaDTO) {
		
		Categoria nuevaCategoria = Categoria.builder().nombre(nuevaCategoriaDTO.getNombre())
				.imagen(nuevaCategoriaDTO.getImagen()).build();
		
		return this.save(nuevaCategoria);
		
	}
	
}
