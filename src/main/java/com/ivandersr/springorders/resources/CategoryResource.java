package com.ivandersr.springorders.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivandersr.springorders.domain.Category;
import com.ivandersr.springorders.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public List<Category> list() {
		Category cat1 = new Category(1, "Informática");
		Category cat2 = new Category(2, "Escritório");
		
		List<Category> list = new ArrayList<Category>();
		list.add(cat1);
		list.add(cat2);
		
		return list;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Category category = service.find(id);
		
		return ResponseEntity.ok().body(category);
	}
	
}
