package com.shippingcompany.deliverymanager.model;

import com.shippingcompany.deliverymanager.model.enumeration.Authority;


public class User {
		
	private String userName;
	
	private String password;
	
	private Authority authority;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
}
