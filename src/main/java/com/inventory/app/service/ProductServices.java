package com.inventory.app.service;

import java.util.ArrayList;

import com.inventory.app.dto.products.ProductDTO;

public interface ProductServices {

	ArrayList<ProductDTO> getAllProducts(String Filter);
	
	ArrayList<ProductDTO> getProductsById(String id);
}
