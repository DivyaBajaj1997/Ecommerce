package com.deloitte.ecommerce.exceptions;

public class AccountAlreadyExist extends RuntimeException {
	public AccountAlreadyExist(String msg) {
		super(msg);
	}
}
