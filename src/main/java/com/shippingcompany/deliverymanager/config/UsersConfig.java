package com.shippingcompany.deliverymanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.shippingcompany.deliverymanager.model.User;
import com.shippingcompany.deliverymanager.model.enumeration.Authority;

@Configuration
public class UsersConfig {
	
	@Bean
	public User rootUser(@Value("${app.api.user.email}") String rootUser, @Value("${app.api.user.password}") String rootPassword, @Value("${app.api.user.authority}")Authority rootAuthority){
		User user = new User();
		user.setUserName(rootUser);
		user.setAuthority(rootAuthority);
		user.setPassword(new BCryptPasswordEncoder().encode(rootPassword));
		return user;
	}
}
