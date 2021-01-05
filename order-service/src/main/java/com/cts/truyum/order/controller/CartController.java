package com.cts.truyum.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.truyum.order.feign.AuthClient;
import com.cts.truyum.order.model.AuthResponse;
import com.cts.truyum.order.service.OrderService;

@RestController
public class CartController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private AuthClient authClient;

	private AuthResponse authResponse;

	@GetMapping("/menuitems/{userId}")
	public ResponseEntity<?> getAllCartItems(@RequestHeader(name = "Authorization") String token,
			@PathVariable int userId) {
		authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			return new ResponseEntity<>(orderService.getAllCartItems(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please login first!", HttpStatus.FORBIDDEN);
		}

	}

	@PostMapping("/add/{userId}/{itemId}")
	public ResponseEntity<String> addMenuItem(@RequestHeader(name = "Authorization") String token,
			@PathVariable int userId, @PathVariable long itemId) {
		authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			return new ResponseEntity<String>(orderService.addMenuItem(token, userId, itemId), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Please login first!", HttpStatus.FORBIDDEN);
		}
	}

	@DeleteMapping("/delete/{userId}/{itemId}")
	public ResponseEntity<String> deleteMenuItem(@RequestHeader(name = "Authorization") String token,
			@PathVariable int userId, @PathVariable long itemId) {
		authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			return new ResponseEntity<String>(orderService.deleteMenuItem(token, userId, itemId), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Please login first!", HttpStatus.FORBIDDEN);
		}
	}
}
