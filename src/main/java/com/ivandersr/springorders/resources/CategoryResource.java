package com.ivandersr.springorders.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivandersr.springorders.domain.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@GetMapping
	public List<Category> list() {
		Category cat1 = new Category(1, "Informática");
		Category cat2 = new Category(2, "Escritório");
		
		List<Category> list = new ArrayList<Category>();
		list.add(cat1);
		list.add(cat2);
		
		return list;
	}
}
