package com.ivandersr.springorders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ivandersr.springorders.domain.Category;
import com.ivandersr.springorders.domain.Product;
import com.ivandersr.springorders.repositories.CategoryRepository;
import com.ivandersr.springorders.repositories.ProductRepository;

@SpringBootApplication
public class SpringordersApplication implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringordersApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Category> existing = categoryRepository.findAll();
		if (existing.size() == 0) {
			Category cat1 = new Category(null, "Informática");
			Category cat2 = new Category(null, "Escritório");
			
			Product prod1 = new Product(null, "Computador", 2000.0);
			Product prod2 = new Product(null, "Impressora", 400.0);
			Product prod3 = new Product(null, "Mouse", 80.0);
			
			cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
			cat2.getProducts().add(prod2);
			
			prod1.getCategories().add(cat1);
			prod2.getCategories().addAll(Arrays.asList(cat1, cat2));
			prod3.getCategories().add(cat1);

			productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
			categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		}
	}

}
