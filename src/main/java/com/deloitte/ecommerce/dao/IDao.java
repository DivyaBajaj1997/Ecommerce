package com.deloitte.ecommerce.dao;

import com.deloitte.ecommerce.entity.Customer;

public interface IDao {
	Customer getUserByMobileNumber(String username);
	Customer addAccount(Customer c);
	boolean credentialsCorrect(String username, String password);
}
