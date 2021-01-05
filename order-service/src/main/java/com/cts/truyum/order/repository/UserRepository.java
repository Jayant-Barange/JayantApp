package com.cts.truyum.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.truyum.order.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
