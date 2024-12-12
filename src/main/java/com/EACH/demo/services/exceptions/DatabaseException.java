package com.EACH.demo.services.exceptions;

//Personalized exception for when occurs an error in the data base structure
public class DatabaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;

		//default RuntimeException constructor
		public DatabaseException(String msg) {
			super(msg);
		}
}
