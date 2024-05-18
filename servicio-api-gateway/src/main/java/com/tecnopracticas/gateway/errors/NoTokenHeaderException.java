package com.tecnopracticas.gateway.errors;

public class NoTokenHeaderException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	public NoTokenHeaderException(String message) {
		super(message);
	}
}
