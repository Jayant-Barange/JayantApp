package com.cts.truyum.menuitem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.truyum.menuitem.feign.AuthClient;
import com.cts.truyum.menuitem.model.AuthResponse;
import com.cts.truyum.menuitem.model.MenuItem;
import com.cts.truyum.menuitem.service.MenuItemService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private MenuItemService menuItemService;

	@Autowired
	private AuthClient authClient;

	private AuthResponse authResponse;

	@GetMapping("/menuitems")
	public ResponseEntity<?> getAdminMenuItems(@RequestHeader(name = "Authorization") String token) {
		authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			return new ResponseEntity<>(menuItemService.getAllMenuItems(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please login first!", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/menuitem/{id}")
	public ResponseEntity<?> getMenuItem(@RequestHeader(name = "Authorization") String token, @PathVariable long id) {
		authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			return new ResponseEntity<>(menuItemService.getMenuItem(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Please login first!", HttpStatus.FORBIDDEN);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<String> addMenuItem(@RequestHeader(name = "Authorization") String token,
			@RequestBody MenuItem menuItem) {
		authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			String rpl = menuItemService.addMenuItem(menuItem);
			return new ResponseEntity<String>(rpl, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Please login first!", HttpStatus.FORBIDDEN);
		}

	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<String> editMenuItem(@RequestHeader(name = "Authorization") String token, @PathVariable long id, @RequestBody MenuItem menuItem) {
		authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			String rpl = menuItemService.editMenuItem(id, menuItem);
			return new ResponseEntity<String>(rpl, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Please login first!", HttpStatus.FORBIDDEN);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMenuItem(@RequestHeader(name = "Authorization") String token, @PathVariable long id) {
		authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			String rpl = menuItemService.deleteMenuItem(id);
			return new ResponseEntity<String>(rpl, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Please login first!", HttpStatus.FORBIDDEN);
		}
		
	}

}
