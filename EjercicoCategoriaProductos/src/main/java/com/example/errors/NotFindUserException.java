package com.example.errors;

public class NotFindUserException extends RuntimeException{

	public NotFindUserException( String usuario) {
		super("El usuario " + usuario + " no existe");
	}
	
}
