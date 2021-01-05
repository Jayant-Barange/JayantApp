package com.cts.truyum.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.truyum.order.exception.CartEmptyException;
import com.cts.truyum.order.exception.MenuItemNotFoundException;
import com.cts.truyum.order.exception.UserNotFoundException;
import com.cts.truyum.order.model.MenuItem;
import com.cts.truyum.order.model.User;
import com.cts.truyum.order.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MenuItemService menuItemService;

	@Override
	public List<MenuItem> getAllCartItems(int userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user with user id " + userId + " doesn't exist"));
		List<MenuItem> cart = user.getCart();
		if (cart.isEmpty()) {
			throw new CartEmptyException("Cart is Empty");
		}
		return cart;

	}

	@Override
	public String addMenuItem(String token, int userId, long itemId) {
		// TODO Auto-generated method stub
		MenuItem item = menuItemService.getMenuItem(token, itemId);
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user with user id " + userId + " doesn't exist"));
		List<MenuItem> cart = user.getCart();
		cart.add(item);
		user.setCart(cart);
		userRepository.save(user);
		return "item with id " + itemId + " successfully added into " + user.getName() + " cart.";
	}

	@Override
	public String deleteMenuItem(String token, int userId, long itemId) {
		// TODO Auto-generated method stub
		MenuItem item = menuItemService.getMenuItem(token, itemId);

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user with user id " + userId + " doesn't exist"));
		List<MenuItem> cart = user.getCart();

		for (MenuItem menuItem : cart) {
			if (menuItem.getId() == item.getId()) {
				cart.remove(menuItem);
				user.setCart(cart);
				userRepository.save(user);
				return "item with id " + itemId + " successfully deleted from " + user.getName() + " cart.";
			}
		}
		throw new MenuItemNotFoundException("menuitem with id " + itemId + " is not present in the cart");

	}

}
