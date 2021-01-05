package com.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.truyum.client.AuthClient;
import com.truyum.model.AuthResponse;
import com.truyum.model.MenuItem;
import com.truyum.service.MenuItemService;

@RestController
@RequestMapping(path="/menu")
public class MenuController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private AuthClient authclient;
	
	
	@RequestMapping(path="/viewall",method=RequestMethod.GET)
	public ResponseEntity<?> getall(@RequestHeader(name="Authorization")String token){
		AuthResponse authResponse= authclient.verifyToken(token);
		if(authResponse.isValid()){
			return new ResponseEntity<>(menuItemService.getMenu(),HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>("You are not LoggedIn",HttpStatus.FORBIDDEN);
		}
		
	}
	
	
	@RequestMapping(path="{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable("id") int id,@RequestHeader(name="Authorization")String token){
		AuthResponse authResponse= authclient.verifyToken(token);
		if(authResponse.isValid()){
			MenuItem item= menuItemService.getItemByID(id);
			if(item!=null){
				return new ResponseEntity<>(item,HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>("Item Not Found",HttpStatus.NOT_FOUND);
			}
		}
		else{
			return new ResponseEntity<>("You are not LoggedIn",HttpStatus.FORBIDDEN);
		}
	}
	@RequestMapping(path="/name/{name}",method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable("name") String name,@RequestHeader(name="Authorization")String token){
		AuthResponse authResponse= authclient.verifyToken(token);
		if(authResponse.isValid()){
			List<MenuItem> items= menuItemService.getItemByName(name);
			if(items!=null && items.size()>0){
				return new ResponseEntity<>(items,HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>("Item Not Found",HttpStatus.NOT_FOUND);
			}
		}
		else{
			return new ResponseEntity<>("You are not LoggedIn",HttpStatus.FORBIDDEN);
		}
	}
}
