package com.deloitte.ecommerce.entity;

public class Customer {

	private String mobileNo;
	private String name;
	private String password;
	private double balance;

	public Customer() {

	}

	public Customer(String mobileNo, String name, String password, double balance) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [mobileNo=" + mobileNo + ", name=" + name + ", password=" + password + ", balance=" + balance
				+ "]";
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || !(obj instanceof Customer)) {
			return false;
		}
		Customer user = (Customer) obj;
		return user.name.equals(this.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
