package com.inventory.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.app.controller.model.User;
import com.inventory.app.controller.model.repository.UserRepository;
import com.inventory.app.dto.GeneralResponseDTO;
import com.inventory.app.service.UserServices;

@Service
public class IUserServices implements UserServices{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getUserById(String id) {
		List<User> UserList = new ArrayList<>();
	    Optional<User> productOptional = userRepository.findById(Long.parseLong(id));
	    
	    if (productOptional.isPresent()) {
	        UserList.add(productOptional.get());
	    }
	    
	    return UserList;
	}

	@Override
	public GeneralResponseDTO addNewUser(User user) {
		try {
			user.setFechaIngreso(new Date());
			User uSave = userRepository.save(user);
			return new GeneralResponseDTO("Success",true,uSave);
		} catch (Exception e) {
			return new GeneralResponseDTO("Error",false,e.getMessage());
		}
	}

}
