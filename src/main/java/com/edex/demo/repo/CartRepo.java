package com.edex.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edex.demo.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

}
