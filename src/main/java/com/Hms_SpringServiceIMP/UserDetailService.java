package com.Hms_SpringServiceIMP;
//importing required classes and packages
import java.util.ArrayList;

import com.Hms_SpringModel.User;
import com.Hms_SpringRepository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class UserDetailService implements UserDetailsService  {
	
	@Autowired
	private UserRepo userepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User u1=userepo.findByUserName(username);
		
		return new org.springframework.security.core.userdetails
				.User(u1.getUserName(), u1.getUserPassword(), new ArrayList<>());
		
	}

}
