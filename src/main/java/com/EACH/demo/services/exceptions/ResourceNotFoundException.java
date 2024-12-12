package com.EACH.demo.services.exceptions;

//personalized exception for when a resource that is searched for isn't found
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " +id);
	}
}
