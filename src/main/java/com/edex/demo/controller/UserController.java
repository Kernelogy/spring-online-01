package com.edex.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.demo.dto.request.UserRequestDto;
import com.edex.demo.dto.response.UserResponseDto;
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
    @GetMapping("/list")
    public ResponseEntity<?> list(){
        List<User> users =  userRepo.findAll();
        List<UserResponseDto> dtos = new ArrayList<UserResponseDto>();
        for(User user : users){
            dtos.add(new UserResponseDto(user.getUsername(), user.getEmail(), user.getContact()));
        }
        return ResponseEntity.ok().body(dtos);
    }
    @GetMapping("/list/{page}/{size}")
    public ResponseEntity<?> listByPage(@PathVariable int page, @PathVariable int size){

        List<User> users =  userRepo.findAll(PageRequest.of(page, size)).toList();
        
        List<UserResponseDto> dtos = new ArrayList<UserResponseDto>();
        for(User user : users){
            dtos.add(new UserResponseDto(user.getUsername(), user.getEmail(), user.getContact()));
        }
        return ResponseEntity.ok().body(dtos);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDto dto){
        User user = userRepo.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if(user !=null){
            return ResponseEntity.ok().body("Login Success");
        }
        return ResponseEntity.ok().body("Login Failed");
    }
}
