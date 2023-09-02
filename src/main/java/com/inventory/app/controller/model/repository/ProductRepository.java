package com.inventory.app.controller.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.app.controller.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
		
}
