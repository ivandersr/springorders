package com.ivandersr.springorders.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivandersr.springorders.domain.Category;
import com.ivandersr.springorders.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	public Category find(Integer id) {
		Optional<Category> category = repository.findById(id);
		return category.orElse(null);
	}
}
