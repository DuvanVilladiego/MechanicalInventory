package com.inventory.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.app.controller.model.Rol;
import com.inventory.app.controller.model.repository.RolRepository;
import com.inventory.app.service.RolServices;

@Service
public class IRolServices implements RolServices{

	@Autowired
	RolRepository rolRepository;

	@Override
	public List<Rol> getAllRols() {
		return rolRepository.findAll();
	}
	
}
