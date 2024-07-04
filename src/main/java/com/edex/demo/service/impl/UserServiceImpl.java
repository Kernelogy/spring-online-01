package com.edex.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edex.demo.model.User;
import com.edex.demo.repo.UserRepo;
import com.edex.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    
    @Override
    public boolean login(String username, String password){
        User user = userRepo.findByUsernameAndPassword(username, password);
        if(user != null){
            return true;
        }
        return false;
    }

}
