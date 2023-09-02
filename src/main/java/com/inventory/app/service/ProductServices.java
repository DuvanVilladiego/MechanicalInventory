package com.inventory.app.service;

import java.util.List;

import com.inventory.app.controller.model.Product;
import com.inventory.app.dto.GeneralResponseDTO;
import com.inventory.app.dto.ProductPatchRequestDTO;

public interface ProductServices {

	List<Product> getAllProducts();
	
	List<Product> getProductsById(String id);
	
	GeneralResponseDTO addNewProduct(Product product);

	GeneralResponseDTO deleteProduct(Long productId, Long userId);

	GeneralResponseDTO updateProduct(Long productId, ProductPatchRequestDTO patchRequest);
}
