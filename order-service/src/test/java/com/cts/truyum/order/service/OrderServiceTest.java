package com.cts.truyum.order.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.truyum.order.model.User;
import com.cts.truyum.order.repository.UserRepository;

@SpringBootTest
public class OrderServiceTest {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MenuItemService menuItemService;
	
	@Test()
	public void testGetAllCartItems() {
		User user = userRepository.getOne(1);
		
	}
}
