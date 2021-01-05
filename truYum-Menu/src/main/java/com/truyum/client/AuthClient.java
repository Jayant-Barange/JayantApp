package com.truyum.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.truyum.model.AuthResponse;

@FeignClient(url="localhost:8000/authapp",name="TRUYUM-AUTH")
public interface AuthClient {
	
	@RequestMapping(path="/validate",method=RequestMethod.GET)
	public AuthResponse verifyToken(@RequestHeader(name="Authorization",required=true)String token);
	
}
