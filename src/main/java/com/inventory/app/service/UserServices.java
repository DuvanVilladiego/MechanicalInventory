package com.inventory.app.service;

import java.util.List;

import com.inventory.app.controller.model.User;
import com.inventory.app.dto.GeneralResponseDTO;

public interface UserServices {

	List<User> getAllUsers();

	List<User> getUserById(String id);
	
	GeneralResponseDTO addNewUser(User user);
}
