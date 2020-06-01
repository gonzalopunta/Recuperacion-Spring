package com.example.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.CrearProductosDTO;
import com.example.DTO.EditarProductosDTO;
import com.example.entity.Productos;
import com.example.errors.ProductoNotFoundException;
import com.example.repository.ProductosRepository;
import com.example.services.ProductosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductoController {

	private final ProductosRepository productosRepository = null;
	private final ProductosService productosService = null;
	
	@GetMapping("/producto/listatodo")
	public List<Productos> obtenerTodos() {
		return productosRepository.findAll();
	}

	@GetMapping("/producto/listauno/{id}")
	public Productos obtenerUno(@PathVariable Long id) {
		return productosRepository.findById(id).orElse(null);
	}

	@PostMapping("/producto/anadir")
	public ResponseEntity<Productos> nuevoProducto(@RequestBody CrearProductosDTO nuevo) {
		System.out.println("entra");
		return ResponseEntity.status(HttpStatus.CREATED).body(productosService.insertar(nuevo));
	}

	@PutMapping("/producto/editar/{id}")
	public Productos editarProducto(@RequestBody EditarProductosDTO editar, @PathVariable Long id) {
		
		return productosService.findById(id).map (productoEditar -> {
			productoEditar.setNombre(editar.getNombre());
			productoEditar.setDescripcion(editar.getDescripcion());
			productoEditar.setPrecio(editar.getPrecio());
			return productosService.save(productoEditar);
		}).orElseThrow(() -> new ProductoNotFoundException(id));

	}

	@DeleteMapping("/producto/borrar/{id}")
	public Productos borrarProducto(@PathVariable Long id) {
		if (productosRepository.existsById(id)) {
			Productos result = productosRepository.findById(id).get();
			productosRepository.deleteById(id);
			return result;
		} else
			return null;
	}
}
