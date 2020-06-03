package com.example.errors;

public class CategoriaNotFoundException extends RuntimeException{
	
	public CategoriaNotFoundException(Long id) {
		super("No se puede encontrar la categoria seleccionada");
	}


	public CategoriaNotFoundException() {
		super("No se pueden encontrar las categorias");
	}

}
