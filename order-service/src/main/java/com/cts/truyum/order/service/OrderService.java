package com.cts.truyum.order.service;

import java.util.List;

import com.cts.truyum.order.model.MenuItem;

public interface OrderService {

	List<MenuItem> getAllCartItems(int userId);

	String addMenuItem(String token, int userId, long itemId);

	String deleteMenuItem(String token, int userId, long itemId);
}
