package com.inventory.app.controller.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.app.dto.GeneralResponseDTO;
import com.inventory.app.dto.products.ProductDTO;
import com.inventory.app.service.ProductServices;

@RestController
@RequestMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class IProductController {

	@Autowired
	private ProductServices productServices;
	
	@GetMapping
	public ResponseEntity<GeneralResponseDTO> getAllProducts(@RequestParam String nombre, @RequestParam Date fecha, @RequestParam String user) {

		ArrayList<ProductDTO> products = productServices.getAllProducts("");
		
		return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Success", true, products),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GeneralResponseDTO> getProductById(@PathVariable String id) {
		// TODO Auto-generated method stub
		return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("", null, ""),HttpStatus.OK);
	}

}
