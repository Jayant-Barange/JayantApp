package com.cts.truyum.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.truyum.menuitem.repository.MenuItemRepository;
import com.cts.truyum.menuitem.service.MenuItemServiceImpl;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class CustomerMenuItemControllerMockito {

	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	public void getCustomerMenuItemsTest() throws Exception {
		mockMvc.perform(get("/customer/menuItems")).andExpect(status().isOk());
	}
	
	@Test
	public void getMenuItemTest() throws Exception {
		mockMvc.perform(get("/customer/menuItem/1")).andExpect(status().isOk());
	}

}
