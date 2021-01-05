package com.cts.truyum.order.service;

import java.util.List;


import com.cts.truyum.order.model.MenuItem;

public interface MenuItemService {
	List<MenuItem> getAllMenuItems(String token);
	MenuItem getMenuItem(String token, long id);
}
