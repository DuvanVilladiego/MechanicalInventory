package com.inventory.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.app.controller.model.Product;
import com.inventory.app.controller.model.repository.ProductRepository;
import com.inventory.app.controller.model.repository.UserRepository;
import com.inventory.app.dto.GeneralResponseDTO;
import com.inventory.app.dto.ProductPatchRequestDTO;
import com.inventory.app.service.ProductServices;

@Service
public class IProductServices implements ProductServices{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductsById(String id) {
	    List<Product> productList = new ArrayList<>();
	    Optional<Product> productOptional = productRepository.findById(Long.parseLong(id));
	    
	    if (productOptional.isPresent()) {
	        productList.add(productOptional.get());
	    }
	    
	    return productList;
	}

	@Override
	public GeneralResponseDTO addNewProduct(Product product) {
		try {
			product.setFechaIngreso(new Date());
			Product pSave = productRepository.save(product);
			return new GeneralResponseDTO("Success",true,pSave);
		} catch (Exception e) {
			return new GeneralResponseDTO("Error",false,null);
		}
	}

	@Override
	public GeneralResponseDTO deleteProduct(Long productId, Long userId) {
	    try {
	        Product product = productRepository.findById(productId).orElse(null);
	        
	        if (product == null) {
	            return new GeneralResponseDTO("Error", false, "El producto no existe.");
	        }

	        if (product.getIdUser().equals( Math.toIntExact(userId))) {
	            productRepository.delete(product);
	            return new GeneralResponseDTO("Success", true, product);
	        } else {
	        	
	            return new GeneralResponseDTO("Error", false, "No tienes permiso para eliminar este producto.");
	        }
	    } catch (Exception e) {
	        return new GeneralResponseDTO("Error", false, e.getMessage());
	    }
	}

	@Override
    public GeneralResponseDTO updateProduct(Long productId, ProductPatchRequestDTO patchRequest) {
        try {
            Optional<Product> optionalProduct = productRepository.findById(productId);

            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();

                if (product.getIdUser().equals(Math.toIntExact(patchRequest.getUserId()))) {
                    if (patchRequest.getNombre() != null) {
                        product.setNombre(patchRequest.getNombre());
                    }
                    if (patchRequest.getCantidad() != null) {
                        product.setCantidad(patchRequest.getCantidad());
                    }
                    productRepository.save(product);

                    return new GeneralResponseDTO("Success", true, product);
                } else {
                    return new GeneralResponseDTO("Error", false, "No tienes permiso para actualizar este producto.");
                }
            } else {
                return new GeneralResponseDTO("Error", false, "El producto no existe.");
            }
        } catch (Exception e) {
            return new GeneralResponseDTO("Error", false, e.getMessage());
        }
    }
	
}
