package com.edex.demo.service;

import org.springframework.stereotype.Service;

public interface UserService {
    public boolean login(String username, String password);
}
