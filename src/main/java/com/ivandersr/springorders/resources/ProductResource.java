package com.ivandersr.springorders.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivandersr.springorders.domain.Product;
import com.ivandersr.springorders.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> list() {
		Product prod1 = new Product(1, "Mouse", 80.0);
		Product prod2 = new Product(2, "Cooler", 70.0);
		
		List<Product> list = new ArrayList<Product>();
		list.add(prod1);
		list.add(prod2);
		
		return list;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Product product = service.find(id);
		
		return ResponseEntity.ok().body(product);
	}
	
}
