package com.cts.truyum.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.truyum.order.feign.MenuItemFeignClient;
import com.cts.truyum.order.model.MenuItem;

@Service
public class MenuItemServiceImpl implements MenuItemService {
	@Autowired
	MenuItemFeignClient menuItemFeignClient;

	@Override
	public List<MenuItem> getAllMenuItems(String token) {
		return menuItemFeignClient.menuItems(token);

	}

	@Override
	public MenuItem getMenuItem(String token, long id) {
		// TODO Auto-generated method stub
		return menuItemFeignClient.menuItem(token, id);
	}

}
