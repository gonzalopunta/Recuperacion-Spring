package com.example.errors;

public class NewUserWithDifferentPasswordsException extends RuntimeException{

	public NewUserWithDifferentPasswordsException() {
		super("Las contraseñas introducidas no son iguales");
	}
	
}
