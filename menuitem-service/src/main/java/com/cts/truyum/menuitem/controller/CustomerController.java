package com.cts.truyum.menuitem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.truyum.menuitem.feign.AuthClient;
import com.cts.truyum.menuitem.model.AuthResponse;
import com.cts.truyum.menuitem.service.MenuItemService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private MenuItemService menuItemService;

	@Autowired
	private AuthClient authClient;

	@GetMapping("/menuitems")
	public ResponseEntity<?> getCustomerMenuItems(@RequestHeader(name = "Authorization") String token) {
		AuthResponse authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			return new ResponseEntity<>(menuItemService.getAllCustomerMenuItems(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please login first!", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/menuitem/{id}")
	public ResponseEntity<?> getMenuItem(@RequestHeader(name = "Authorization") String token, @PathVariable long id) {
		AuthResponse authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			return new ResponseEntity<>(menuItemService.getCustomerMenuItem(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please login first!", HttpStatus.FORBIDDEN);
		}
	}
}
