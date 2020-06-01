package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.CrearProductosDTO;
import com.example.entity.Productos;
import com.example.repository.ProductosRepository;

@Service
public class ProductosService extends BaseService<Productos, Long, ProductosRepository>{

	@Autowired
	ProductosRepository productosRepository;
	CategoriaService categoriaService;
	
	public List<Productos> listarTodos() {
		return productosRepository.findAll();
	}
	
	public void listarPorId(Long id) {
		productosRepository.getOne(id);
	}
	
	public Productos insertar(CrearProductosDTO p) {

		Productos nuevosProductos = Productos.builder()
				.nombre(p.getNombre())
				.descripcion(p.getDescripcion())
				.precio(p.getPrecio())
				.categoria(categoriaService.findById(p.getCategoriaId()).orElse(null))
				.build();
		return this.save(nuevosProductos);
	}
	
	public void borrarProducto(Productos p) {
		productosRepository.delete(p);
	}
	
	public Productos editar(Productos p) {
		return productosRepository.save(p);
	}

}
