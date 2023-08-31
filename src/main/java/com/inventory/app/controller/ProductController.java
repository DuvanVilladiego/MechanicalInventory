package com.inventory.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.app.controller.model.Product;
import com.inventory.app.dto.GeneralResponseDTO;
import com.inventory.app.service.ProductServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	private ProductServices productServices;
	
	@GetMapping
	public ResponseEntity<GeneralResponseDTO> getAllProducts(@RequestParam(required = false) String nombre, @RequestParam(required = false) Date fecha, @RequestParam(required = false) String user) {

		try {
			List<Product> products = productServices.getAllProducts("");
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Success", true, products),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Error", false, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GeneralResponseDTO> getProductById(@PathVariable String id) {
		try {
			Product products = productServices.getProductsById(id);
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Success", true, products),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Error", false, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
