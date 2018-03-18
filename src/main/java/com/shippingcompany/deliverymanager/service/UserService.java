package com.shippingcompany.deliverymanager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shippingcompany.deliverymanager.model.User;

@Service
public class UserService {
	
	@Autowired
	private User user;


	public User loadUserByUsername(String email) {
		return (user.getUserName().equals(email)) ? user : null; 
	}
	

}
