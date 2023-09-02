package com.inventory.app.controller.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.app.controller.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

		
}
