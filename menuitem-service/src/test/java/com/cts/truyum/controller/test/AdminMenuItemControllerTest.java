package com.cts.truyum.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.truyum.menuitem.model.MenuItem;
import com.cts.truyum.menuitem.repository.MenuItemRepository;
import com.cts.truyum.menuitem.service.MenuItemServiceImpl;

@SpringBootTest
public class AdminMenuItemControllerTest {

	@Autowired
	 private  MenuItemServiceImpl menuItemServiceImpl ;

	@Test
	@GetMapping("/menuitems")
	public void getAllMenuItemsTest(){
		List <MenuItem> menuitemList=menuItemServiceImpl.getAllMenuItems();
		assertEquals(true, menuitemList.size() != 0);
		
	}
	
	@Test
	
	public void getMenuItemTest() {
		MenuItem menuitem = menuItemServiceImpl.getMenuItem(5);
		assertEquals(menuitem.getId(), 5);

	}
	
//	@Test
//	public void editMenuItemTest() {
//	    MenuItem menuItem = menuItemServiceImpl.getMenuItem((long) 5);  
//		menuItem.get().setPrice(299);		
//		menuItemServiceImpl.save(menuItem.get());
//		Optional<MenuItem> updatedmenuItem = menuItemServiceImpl.findById((long) 5);
//		assertEquals(updatedmenuItem.get().getPrice(), 299);
//	}
//	
}
