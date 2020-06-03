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

import com.example.DTO.CrearCategoriaDTO;
import com.example.DTO.EditarCategoriaDTO;
import com.example.entity.Categoria;
import com.example.errors.CategoriaNotFoundException;
import com.example.services.CategoriaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoriaController {
	
	private final CategoriaService categoriaService;
	
	@GetMapping("/categoria")
	public List<Categoria> obtenerTodos() {
		return categoriaService.findAll();
	}
	
	@GetMapping("/categoria/listauna/{id}")
	public Categoria obtenerUno(@PathVariable Long id) {
		return categoriaService.findById(id).orElse(null);
	}
	
	@PostMapping ("/categoria")
	public ResponseEntity<Categoria> nuevaCategoria (@RequestBody CrearCategoriaDTO nueva){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.insertarCategoria(nueva));		
	}
	
	@PutMapping("/categoria/{id}")
	public Categoria editarCategoria(@RequestBody EditarCategoriaDTO editar, @PathVariable Long id) {
		
		return categoriaService.findById(id).map (categoriaEditar -> {
			categoriaEditar.setNombre(editar.getNombre());
			categoriaEditar.setImagen(editar.getImagen());
			return categoriaService.save(categoriaEditar);
		}).orElseThrow(() -> new CategoriaNotFoundException(id));

	}
	
	@DeleteMapping("/categoria/{id}")
	public Categoria borrarCategoria (@PathVariable Long id) {
		if (categoriaService.findById(id) != null) {
			Categoria result = categoriaService.findById(id).get();
			categoriaService.deleteById(id);
			return result;
		} else
			return null;
	}

}
