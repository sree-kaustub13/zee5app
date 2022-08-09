package com.zee.zee5app.exceptions;

public class UnableToGenerateIdException extends Exception {
	
	public UnableToGenerateIdException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return super.getMessage();
	}

}
