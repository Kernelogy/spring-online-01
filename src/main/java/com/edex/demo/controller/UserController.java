package com.edex.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edex.demo.dto.request.UserRequestDto;
import com.edex.demo.dto.response.UserCreationResponse;
import com.edex.demo.dto.response.UserResponseDto;
import com.edex.demo.model.Product;
import com.edex.demo.model.User;
import com.edex.demo.repo.UserRepo;
import com.edex.demo.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired  //The object is initiated automiatically whenever it is required
    private UserRepo userRepo;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody User user){
        System.out.println("Controller working....");
        User entity = userRepo.save(user); 
        if(entity != null){
            UserCreationResponse dto = new UserCreationResponse(
                true, "Account Created Successfully"
            );
            return ResponseEntity.ok().body(dto);
        }else{
            UserCreationResponse dto = new UserCreationResponse(
                false, "Account Creation Failed"
            );
            return ResponseEntity.ok().body(dto);
        }

    }
    @PostMapping("/insertWithAddress")
    public ResponseEntity<User> insertWithAddress(@RequestBody User user){
        User entity = userRepo.save(user);
        return ResponseEntity.ok().body(entity);
    }
    @GetMapping("/list")
    public ResponseEntity<?> list(){
        List<User> users =  userRepo.findAll();        
        
        /*
        List<UserResponseDto> dtos = new ArrayList<UserResponseDto>();
        for(User user : users){
            dtos.add(new UserResponseDto(user.getUsername(), user.getEmail(), user.getContact()));
        }
        return ResponseEntity.ok().body(dtos);
        */
        return ResponseEntity.ok().body(users);
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

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        // SELECT * FROM USERS WHERE ID = 1
        User user = userRepo.findById(id).get();
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username){
        // SELECT * FROM USERS WHERE ID = 1
        User user = userRepo.findByUsername(username);
        UserResponseDto dto = new UserResponseDto(user.getUsername(), 
                                                    user.getEmail(), 
                                                    user.getPassword());
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDto user){
        /*
        User entity = userRepo.findByUsernameAndPassword(
                            user.getUsername(), user.getPassword()
                            );
        if(entity != null){
            return ResponseEntity.ok().body("Login Success");
        }

        return ResponseEntity.ok().body("Login Failed");
        */

        boolean status = userService.login(user.getUsername(), user.getPassword());
        return ResponseEntity.ok().body(status);
    }
    @GetMapping("/listByEmailOrContact")
    public ResponseEntity<?> findByEmailOrContact(){
        List<User> users = userRepo.findByEmailOrContact("mukil@edex.com", "");
        return ResponseEntity.ok().body(users);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        userRepo.deleteById(id);
        return ResponseEntity.ok().body("Deleted Successfully");
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateById(@RequestBody User user){
        //data without primary key = new record inserted
        //data with primary key = existing record is updated
        User entity = userRepo.save(user);
        return ResponseEntity.ok().body(entity);
    }

    @GetMapping("/findByComplex/{username}")
    public ResponseEntity<?> findByComplex(@PathVariable String username){
        User user = userRepo.findBySomeComplexQuery(username);
        return ResponseEntity.ok().body(user);
    }



}
