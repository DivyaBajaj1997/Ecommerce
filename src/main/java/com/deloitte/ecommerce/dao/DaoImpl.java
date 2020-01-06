package com.deloitte.ecommerce.dao;

import java.util.HashMap;
import java.util.Map;
import com.deloitte.ecommerce.entity.Customer;
import com.deloitte.ecommerce.exceptions.AccountAlreadyExist;


public class DaoImpl implements IDao {

	private Map<String, Customer> store = new HashMap<>();

	public DaoImpl() {
	        Customer user1 = new Customer("9999900000", "Divya", "1234", 880.67);
	        addAccount(user1);
	        //store.put("9999900000", user1);
	        Customer user2 = new Customer("9999923445", "kavya", "3456", 578.89);
	        addAccount(user2);
	        //store.put("9999923445", user2);
	}

	@Override
	public boolean credentialsCorrect(String username, String password) {
		Customer user = store.get(username);
		if (user == null) {
			return false;
		}
		return user.getPassword().equals(password);
	}

	@Override
	public Customer getUserByMobileNumber(String username) {
		Customer user = store.get(username);
		return user;
	}
	@Override
	public Customer addAccount(Customer cust) {
		Customer c = store.get(cust.getMobileNo());
		if (c != null) {
			throw new AccountAlreadyExist("An account is already linked with this mobile no");
		}
		store.put(cust.getMobileNo(), cust);
		return cust;
	}

}
