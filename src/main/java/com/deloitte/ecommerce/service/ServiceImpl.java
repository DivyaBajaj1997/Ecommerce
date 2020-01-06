package com.deloitte.ecommerce.service;
import com.deloitte.ecommerce.dao.DaoImpl;
import com.deloitte.ecommerce.dao.IDao;
import com.deloitte.ecommerce.entity.Customer;
import com.deloitte.ecommerce.exceptions.InvalidMobileNumberException;

public class ServiceImpl implements Service {

	private IDao dao = new DaoImpl();

	public IDao getCustomerDao() {
		return dao;
	}

	public ServiceImpl(IDao DaoImp) {
		this.dao = DaoImp;
	}

	public void validateMobileNo(String mobileNo) {
		if (mobileNo == null || mobileNo.length() != 10) {
			throw new InvalidMobileNumberException("Invalid Mobile Number");
		}
	}
	
	@Override
	public Customer addAccount(Customer c) {
		validateMobileNo(c.getMobileNo());
		return dao.addAccount(c);
	}
	
	@Override
	public Customer getUserByMobileNumber(String username) {
		validateMobileNo(username);
		Customer user = dao.getUserByMobileNumber(username);
		return user;
	}

	@Override
	public boolean credentialsCorrect(String username, String password) {
		boolean correct = dao.credentialsCorrect(username, password);
		return correct;
	}
}
