package com.cts.truyum.menuitem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.truyum.menuitem.exception.InvalidMenuItem;
import com.cts.truyum.menuitem.exception.MenuItemNotAvailableException;
import com.cts.truyum.menuitem.exception.MenuItemNotFoundException;
import com.cts.truyum.menuitem.model.MenuItem;
import com.cts.truyum.menuitem.repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public List<MenuItem> getAllMenuItems() {
		List<MenuItem> list = menuItemRepository.findAll();
		return list;
	}

	@Override
	public MenuItem getMenuItem(long id) {
		// TODO Auto-generated method stub
		return menuItemRepository.findById(id)
				.orElseThrow(() -> new MenuItemNotFoundException("menu item with id " + id + " doesn't exist"));
	}

	@Override
	public String editMenuItem(long id, MenuItem menuItem) {
		MenuItem item = menuItemRepository.findById(id)
				.orElseThrow(() -> new MenuItemNotFoundException("menu item with id " + id + " doesn't exist"));

		if (menuItem.getName() != null) {
			item.setName(menuItem.getName());
		}
		if (menuItem.getPrice() != 0.0) {
			item.setPrice(menuItem.getPrice());
		}
		if (menuItem.getCategory() != null) {
			item.setCategory(menuItem.getCategory());
		}
		if (menuItem.getDateOfLaunch() != null) {
			item.setDateOfLaunch(menuItem.getDateOfLaunch());
		}
		item.setActive(menuItem.isActive());
		item.setFreeDelivery(menuItem.isFreeDelivery());

		menuItemRepository.save(item);

		return "MenuItem with the id " + id + " updated successfully";
	}

	@Override
	public String addMenuItem(MenuItem menuItem) {
		if (menuItem.getName() == null || menuItem.getPrice() == 0.0f || menuItem.getCategory() == null
				|| menuItem.getDateOfLaunch() == null) {
			throw new InvalidMenuItem("Complete details required");
		}
		menuItemRepository.save(menuItem);
		return "MenuItem  added successfully";
	}

	@Override
	public String deleteMenuItem(long id) {
		MenuItem menuItem = menuItemRepository.findById(id)
				.orElseThrow(() -> new MenuItemNotFoundException("menu item with id " + id + " doesn't exist"));
		menuItemRepository.delete(menuItem);
		return "MenuItem with the id " + id + " deleted successfully";
	}

	@Override
	public List<MenuItem> getAllCustomerMenuItems() {
		List<MenuItem> list = menuItemRepository.findAll();
		List<MenuItem> customerMenuItems = new ArrayList<MenuItem>();

		Iterator<MenuItem> itr = list.iterator();
		MenuItem menuItem;
		while (itr.hasNext()) {
			menuItem = itr.next();
			if (menuItem.isActive() && menuItem.getDateOfLaunch().before(new Date())) {

				customerMenuItems.add(menuItem);

			}

		}
		return customerMenuItems;
	}

	@Override
	public MenuItem getCustomerMenuItem(long id) {
		MenuItem menuItem = menuItemRepository.findById(id)
				.orElseThrow(() -> new MenuItemNotFoundException("menu item with id " + id + " doesn't exist"));
		if (!menuItem.isActive() || !menuItem.getDateOfLaunch().before(new Date())) {
			throw new MenuItemNotAvailableException("MenuItem with id " + id + " is not available");
		}
		return menuItem;
	}

}
