package com.cts.truyum.menuitem.repository;

import org.springframework.stereotype.Repository;

import com.cts.truyum.menuitem.model.MenuItem;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long>{
	
}
