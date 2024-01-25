package com.ivandersr.springorders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivandersr.springorders.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {}
