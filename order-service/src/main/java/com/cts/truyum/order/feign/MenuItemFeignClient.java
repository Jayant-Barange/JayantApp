package com.cts.truyum.order.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.truyum.order.model.MenuItem;

import feign.Headers;

@Headers("Content-Type: application/json")
//@FeignClient(name = "menuitem-service", url = "${MENUITEM_SERVICE:http://localhost:5000}")

@FeignClient(name = "menuitem-service", url = "${feign.url}")
public interface MenuItemFeignClient {
	
	@GetMapping("/customer/menuitems") 
	List<MenuItem> menuItems(@RequestHeader(name = "Authorization") String token);
	

	@GetMapping("/customer/menuitem/{id}") 
	MenuItem menuItem(@RequestHeader(name = "Authorization") String token, @PathVariable long id);

}
