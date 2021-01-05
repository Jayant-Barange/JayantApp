package com.truyum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truyum.model.MenuItem;

public interface MenuItemDao extends JpaRepository<MenuItem, Integer>{

}
