package com.inventory.app.service;

import java.util.List;

import com.inventory.app.controller.model.Product;

public interface ProductServices {

	List<Product> getAllProducts(String Filter);
	
	Product getProductsById(String id);
}
