package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.CrearProductosDTO;
import com.example.entity.Productos;
import com.example.repository.ProductosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductosService extends BaseService<Productos, Long, ProductosRepository>{

	private final CategoriaService categoriaService;
	
	public Productos insertar(CrearProductosDTO p) {

		Productos nuevosProductos = Productos.builder()
				.nombre(p.getNombre())
				.descripcion(p.getDescripcion())
				.precio(p.getPrecio())
				.categoria(categoriaService.findById(p.getCategoriaId()).orElse(null))
				.build();
		return this.save(nuevosProductos);
	}
}
