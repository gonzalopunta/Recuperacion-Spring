package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Categoria;
import com.example.repository.CategoriaRepository;

@Service
public class CategoriaService extends BaseService<Categoria, Long, CategoriaRepository>{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> listarTodos() {
		return categoriaRepository.findAll();
	}
	
	public void listarPorId(Long id) {
		categoriaRepository.getOne(id);
	}
	
	public Categoria insertar(Categoria c) {
		return categoriaRepository.save(c);
	}
	
	public void borrarProducto(Categoria c) {
		categoriaRepository.delete(c);
	}
	
	public Categoria editar(Categoria c) {
		return categoriaRepository.save(c);
	}
}
