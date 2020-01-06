package com.deloitte.ecommerce.exceptions;

public class InvalidMobileNumberException extends RuntimeException {
	public InvalidMobileNumberException(String msg) {
		super(msg);
	}
}