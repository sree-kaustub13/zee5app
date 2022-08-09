package com.zee.zee5app.exceptions;

public class InvalidNameException extends Exception {
	
	
	
	public InvalidNameException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.getMessage();
	}
	

}
