package com.inventory.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.app.controller.model.User;
import com.inventory.app.dto.GeneralResponseDTO;
import com.inventory.app.service.UserServices;

import jakarta.websocket.server.PathParam;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserServices userServices;
	
	@GetMapping
	public ResponseEntity<GeneralResponseDTO> getUsers(@PathParam(value = "id") String id) {
		List<User> users = new ArrayList<User>();
		try {
			if (id!=null) {
				users = userServices.getUserById(id);
			} else {
				users = userServices.getAllUsers();
			}
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Success", true, users),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Error", false, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<GeneralResponseDTO> getUsers(@RequestBody User body) {
		try {
			GeneralResponseDTO response = userServices.addNewUser(body);
			return new ResponseEntity<GeneralResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Error", false, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
