package com.cts.truyum.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.truyum.menuitem.model.MenuItem;
import com.cts.truyum.menuitem.repository.MenuItemRepository;
import com.cts.truyum.menuitem.service.MenuItemServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class AdminMenuItemControllerMockito {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	 private MenuItemRepository menuItemRepository;
	
	@MockBean
	private MenuItemServiceImpl menuItemServiceImpl;
	
	@Test
	public void getAdminMenuItemsTest() throws Exception {
		mockMvc.perform(get("/admin/menuItems")).andExpect(status().isOk());
	}

	@Test
	public void getMenuItemTest() throws Exception {
		mockMvc.perform(get("/admin/menuItem/1")).andExpect(status().isOk());
	}
	
//	@Test
//	public void addMenuItemTest() throws Exception {
//		mockMvc.perform(
//				MockMvcRequestBuilders.post("/admin/add").content(asJsonString(new MenuItem(6,"Burger",149,1, new java.sql.Date(2020 - 10 - 28),"Starter",1)))
//						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isCreated());
//	}
	

//	@Test
//	public void editMenuItemTest() throws Exception {
//		mockMvc.perform(
//				MockMvcRequestBuilders.put("/admin/edit/6").content(asJsonString(new MenuItem(6,"Burger",149,1, new java.sql.Date(2020 - 10 - 28),"Starter",1)))
//						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//	}
	
	@Test
	public void deleteMenuItem() throws Exception {
		mockMvc.perform(delete("/admin/delete/6")).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
