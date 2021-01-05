package com.cts.truyum.menuitem.service;

import java.util.List;

import com.cts.truyum.menuitem.model.MenuItem;

public interface MenuItemService {
	List<MenuItem> getAllMenuItems();

	MenuItem getMenuItem(long id);

	String editMenuItem(long id, MenuItem menuItem);

	String addMenuItem(MenuItem menuItem);

	String deleteMenuItem(long id);

	List<MenuItem> getAllCustomerMenuItems();

	MenuItem getCustomerMenuItem(long id);
}
