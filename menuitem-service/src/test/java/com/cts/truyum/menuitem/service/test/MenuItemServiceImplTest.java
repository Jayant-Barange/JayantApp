package com.cts.truyum.menuitem.service.test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cts.truyum.menuitem.model.MenuItem;
import com.cts.truyum.menuitem.repository.MenuItemRepository;

@SpringBootTest
public class MenuItemServiceImplTest {

	@Autowired
	  MenuItemRepository menuItemRepository ;
	
	@Test
	public void getAllMenuItemsTest(){
		List <MenuItem> menuitemList=menuItemRepository.findAll();
		assertEquals(true, menuitemList.size() != 0);
		
	}
	
	@Test
	public void getMenuItemTest() {
		Optional<MenuItem> menuitem = menuItemRepository.findById((long) 5);
		assertEquals(menuitem.get().getId(), 5);

	}
	
	@Test
	public void editMenuItemTest() {
		Optional<MenuItem> menuItem = menuItemRepository.findById((long) 5);  
		menuItem.get().setPrice(299);		
		menuItemRepository.save(menuItem.get());
		Optional<MenuItem> updatedmenuItem = menuItemRepository.findById((long) 5);
		assertEquals(updatedmenuItem.get().getPrice(), 299);
	}
	
//	@Test
//	@RollBack(false)
//	public void addMenuItemTest() {
//		MenuItem menuItem = menuItemRepository
//				.save(new MenuItem(6,"Burger",149,1, new java.sql.Date(2020 - 10 - 28),"Starter",1));
//
//		assertThat(menuItem.getId()).isGreaterThan(0);
//	}
	
	
//	@Test
//	@Rollback(false)
//	public void deleteMenuItemTest() {
//	MenuItem menuItem = menuItemRepository
//			.save(new MenuItem(6,"Burger",149,'1', new java.sql.Date(2020 - 10 - 28),"Starter",'1'));
//		List<MenuItem> menuItemlist= menuItemRepository.findAll();
//		long id =  menuItemlist.get(menuItemlist.size()-1).getId();
//		menuItemRepository.deleteById(id);
//		Optional<MenuItem> deletedMenuItem = menuItemRepository.findById((long) 10);
//
//		assertThat(deletedMenuItem).isEmpty();
//	}
	
	@Test
	public void getAllCustomerMenuItemsTest(){
		List <MenuItem> menuitemList=menuItemRepository.findAll();
		assertEquals(true, menuitemList.size() != 0);
		
	}
	@Test
	public void getCustomerMenuItemTest() {
		Optional<MenuItem> menuitem = menuItemRepository.findById((long) 5);
		assertEquals(menuitem.get().getId(), 5);

	}
}
