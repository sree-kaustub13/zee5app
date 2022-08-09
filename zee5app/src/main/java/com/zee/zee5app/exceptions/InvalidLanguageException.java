package com.zee.zee5app.exceptions;

public class InvalidLanguageException extends Exception{
	public InvalidLanguageException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.getMessage();
	}
}
