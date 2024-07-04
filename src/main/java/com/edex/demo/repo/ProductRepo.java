package com.edex.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edex.demo.model.Product;

public interface ProductRepo  extends JpaRepository<Product, Integer>{

}
