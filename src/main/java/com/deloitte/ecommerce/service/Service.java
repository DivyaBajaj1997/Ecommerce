package com.deloitte.ecommerce.service;

import com.deloitte.ecommerce.entity.Customer;

public interface Service {
	Customer getUserByMobileNumber(String username);
	boolean credentialsCorrect(String username, String password);
	Customer addAccount(Customer c);

}
