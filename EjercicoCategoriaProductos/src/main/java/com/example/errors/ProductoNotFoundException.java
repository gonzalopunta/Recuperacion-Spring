package com.example.errors;

public class ProductoNotFoundException extends RuntimeException{

	public ProductoNotFoundException(Long id) {
		super("No se puede encontrar el producto deseado");
	}


	public ProductoNotFoundException() {
		super("No se pueden encontrar productos");
	}
	
}
