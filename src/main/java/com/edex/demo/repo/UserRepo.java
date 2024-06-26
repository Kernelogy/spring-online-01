package com.edex.demo.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.edex.demo.model.User;
import java.util.List;


//The Repo class must inherit the 
// JpaRepository<model class, data_type of primarykey> class

public interface UserRepo extends JpaRepository<User, Integer>{
    User findByUsernameAndPassword(String username, String password);
}
