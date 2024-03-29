package com.ivandersr.springorders.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivandersr.springorders.domain.Product;
import com.ivandersr.springorders.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public Product find(Integer id) {
		Optional<Product> product = repository.findById(id);
		return product.orElse(null);
	}
}
