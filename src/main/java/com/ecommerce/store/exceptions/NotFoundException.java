package com.ecommerce.store.exceptions;

public class NotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	
	public NotFoundException (String mensage) {
		super(mensage);
	}

	
}
