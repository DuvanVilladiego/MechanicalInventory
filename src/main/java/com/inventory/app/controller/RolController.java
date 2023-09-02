package com.inventory.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.app.controller.model.Rol;
import com.inventory.app.dto.GeneralResponseDTO;
import com.inventory.app.service.RolServices;

import jakarta.websocket.server.PathParam;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/rols", produces = MediaType.APPLICATION_JSON_VALUE)
public class RolController {

	@Autowired
	private RolServices rolServices;
	
	@GetMapping
	public ResponseEntity<GeneralResponseDTO> getRols(@PathParam(value = "id") String id) {
		List<Rol> rols = new ArrayList<Rol>();
		try {
			rols = rolServices.getAllRols();
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Success", true, rols),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Error", false, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
