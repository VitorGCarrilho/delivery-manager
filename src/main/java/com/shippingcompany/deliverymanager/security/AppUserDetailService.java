package com.shippingcompany.deliverymanager.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shippingcompany.deliverymanager.service.UserService;

@Service
public class AppUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.shippingcompany.deliverymanager.model.User user = userService.loadUserByUsername(email);
		Set<SimpleGrantedAuthority> authorities = new HashSet<>(); 
		authorities.add(new SimpleGrantedAuthority(user.getAuthority().toString()));
		
		return new User(user.getUserName(), user.getPassword(), authorities);
	}

}
