package com.deloitte.ecommerce.Ui;

import java.util.Collection;
import java.util.Set;

import com.deloitte.ecommerce.dao.DaoImpl;
import com.deloitte.ecommerce.entity.Customer;
import com.deloitte.ecommerce.exceptions.CustomerNotFoundException;
import com.deloitte.ecommerce.exceptions.InvalidMobileNumberException;
import com.deloitte.ecommerce.service.Service;
import com.deloitte.ecommerce.service.ServiceImpl;

public class UI {
	Service c = new ServiceImpl(new DaoImpl());

	public static void main(String[] args) {
		UI ui = new UI();
		ui.execute();
	}

	public void execute() {
		try {
			Customer c1 = new Customer("9999900000", "Divya", "1234", 880.67);
			Customer c2 = new Customer("9999923445", "kavya", "3456", 578.89);
			c.addAccount(c1);
			c.addAccount(c2);
			
			Customer c3 = c.getUserByMobileNumber("9999900000");
			System.out.println(c3.getName());
			
		} catch (CustomerNotFoundException e) {
			System.out.println("Customer not found");
		} catch (InvalidMobileNumberException e) {
			System.out.println("Invalid Mobile No");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
	}
}
