package com.inventory.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.app.controller.model.Product;
import com.inventory.app.controller.model.repository.ProductRepository;
import com.inventory.app.service.ProductServices;

@Service
public class IProductServices implements ProductServices{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts(String Filter) {
		return productRepository.findAll();
	}

	@Override
	public Product getProductsById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
