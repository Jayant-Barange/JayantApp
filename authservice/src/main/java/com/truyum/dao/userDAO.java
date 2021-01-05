package com.truyum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truyum.model.UserTruyum;

@Repository
public interface userDAO extends JpaRepository<UserTruyum, String> {

}
