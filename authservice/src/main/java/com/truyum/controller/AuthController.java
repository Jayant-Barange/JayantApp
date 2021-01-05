package com.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.truyum.dao.userDAO;
import com.truyum.model.AuthResponse;
import com.truyum.model.UserLoginCredential;
import com.truyum.model.UserToken;
import com.truyum.service.CustomerDetailsService;
import com.truyum.service.JwtUtil;



@RestController
@RequestMapping("/authapp")
public class AuthController {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomerDetailsService custdetailservice;
	@Autowired
	private userDAO userservice;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<UserToken> login(@RequestBody UserLoginCredential userlogincredentials)
	{
		final UserDetails userdetails = custdetailservice.loadUserByUsername(userlogincredentials.getUid()); 
		return new ResponseEntity<>(new UserToken(userlogincredentials.getUid(),jwtutil.generateToken(userdetails)),HttpStatus.OK);

	}
	
	@RequestMapping(value="/validate",method=RequestMethod.GET)
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token)
	{
		token=token.substring(7);
		AuthResponse res=new AuthResponse();
		if(jwtutil.validateToken(token))
		{
			res.setUid(jwtutil.extractUsername(token));
			res.setValid(true);
			res.setName((userservice.findById(jwtutil.extractUsername(token)).orElse(null).getUname()));
			
		}
		else
			res.setValid(false);
		System.out.println("res:"+res);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
}
