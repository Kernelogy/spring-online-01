package com.edex.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.demo.model.User;
import com.edex.demo.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired  //The object is initiated automiatically whenever it is required
    private UserRepo userRepo;

    @PostMapping("/insert")
    public ResponseEntity<User> insert(@RequestBody User user){
        User entity = userRepo.save(user);
        return ResponseEntity.ok().body(entity);
    }
}
