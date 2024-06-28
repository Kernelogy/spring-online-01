package com.edex.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edex.demo.model.User;
import java.util.List;


//The Repo class must inherit the 
// JpaRepository<model class, data_type of primarykey> class

public interface UserRepo extends JpaRepository<User, Integer>{

    //SELECT * FROM USERS WHERE username = 'value'
    User findByUsername(String username);

    //SELECT * FROM USERS WHERE username = 'value' AND password = 'value'
    User findByUsernameAndPassword(String username, String password);

    //SELECT * FROM USERS WHERE email = 'value' OR contact = 'value'
    List<User> findByEmailOrContact(String email, String contact);

    //Positional Parameter
    // @Query(value = "SELECT * FROM users WHERE username = ?1 AND ?2", nativeQuery = true)
    // User findBySomeComplexQuery(String username, String password);

    //Named Parameter
    // @Query(value = "SELECT * FROM users WHERE username = :username AND :password", nativeQuery = true)
    // User findBySomeComplexQuery(String username, String password);

    // @Query(value = "SELECT * FROM users WHERE username = ?1", nativeQuery = true)
    // User findBySomeComplexQuery(String username);

    @Query(value = "SELECT * FROM users WHERE username = :username", nativeQuery = true)
    User findBySomeComplexQuery(String username);


}


