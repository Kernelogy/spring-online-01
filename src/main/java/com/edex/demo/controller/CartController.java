package com.edex.demo.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edex.demo.model.Cart;
import com.edex.demo.model.Product;
import com.edex.demo.repo.CartRepo;
import com.edex.demo.repo.ProductRepo;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Cart cart){
        Set<Product> products = new HashSet<Product>();
        for(Product p : cart.getProducts()){
            Product ele = productRepo.save(p);
            products.add(ele);
        }
        cart.setProducts(products);
        Cart entity = cartRepo.save(cart);
       
        return ResponseEntity.ok().body(entity);
    }
}
