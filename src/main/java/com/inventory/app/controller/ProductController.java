package com.inventory.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.app.controller.model.Product;
import com.inventory.app.dto.DeleteProductRequestDTO;
import com.inventory.app.dto.GeneralResponseDTO;
import com.inventory.app.dto.ProductPatchRequestDTO;
import com.inventory.app.service.ProductServices;

import jakarta.websocket.server.PathParam;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	private ProductServices productServices;
	
	@GetMapping
	public ResponseEntity<GeneralResponseDTO> getProducts(@PathParam(value = "id") String id) {
		List<Product> products = new ArrayList<Product>();
		try {
			if (id!=null) {
				products = productServices.getProductsById(id);
			} else {
				products = productServices.getAllProducts();
			}
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Success", true, products),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Error", false, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<GeneralResponseDTO> addProduct(@RequestBody Product body ) {
		try {
			GeneralResponseDTO response = productServices.addNewProduct(body);
			return new ResponseEntity<GeneralResponseDTO>(response,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Error", false, e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<GeneralResponseDTO> deleteProduct(@RequestBody DeleteProductRequestDTO request) {
	    try {
	        GeneralResponseDTO response = productServices.deleteProduct(request.getProductId(), request.getUserId());
	        return new ResponseEntity<GeneralResponseDTO>(response, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Error", false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PatchMapping("/{productId}")
	public ResponseEntity<GeneralResponseDTO> updateProduct(@PathVariable Long productId, @RequestBody ProductPatchRequestDTO patchRequest ) {	    try {
	        GeneralResponseDTO response = productServices.updateProduct(productId, patchRequest);
	        return new ResponseEntity<GeneralResponseDTO>(response, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO("Error", false, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


}
