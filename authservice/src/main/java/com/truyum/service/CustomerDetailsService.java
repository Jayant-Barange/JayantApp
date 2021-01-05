package com.truyum.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.truyum.dao.userDAO;
import com.truyum.model.UserTruyum;


@Service
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private userDAO userdao;
	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserTruyum custuser=userdao.findById(uid).orElse(null);
		return new User(custuser.getUserid(), custuser.getUpassword(), new ArrayList<>());
		
		
	}

}
