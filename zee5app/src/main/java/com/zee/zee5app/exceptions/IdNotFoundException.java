package com.zee.zee5app.exceptions;


public class IdNotFoundException extends Exception {

	
	public IdNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return super.getMessage();
	}

}
