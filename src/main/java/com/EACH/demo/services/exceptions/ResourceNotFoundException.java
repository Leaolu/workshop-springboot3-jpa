package com.EACH.demo.services.exceptions;

//exception for when the id isn't found
//error 404
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " +id);
	}
}
