package com.edex.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edex.demo.model.User;


@RestController
@RequestMapping(path = "/demo")
public class DemoController {
	//Define the function and map it to a corresponding url
	@GetMapping("/sayHello")  
	public String sayHello() {
		return "Hello World";
	}

	@GetMapping("/sayHi")
	public String sayHi(){
		return "Mother Earth";
	}   
    @PostMapping("/login")
    public String login() {
        return "Login Success";
    }
    // http://localhost:9000/demo/signin?username=mukil&password=12345
    @GetMapping("/signin")
    public String signin(@RequestParam String username, 
                         @RequestParam String password){
        System.out.println(username + " " + password);
        if(username.equals("admin") && password.equals("12345")){
            return "Success";
        }
        return "Failed";
    } 
    @PostMapping("/signin")
    public String signinPost(@RequestBody User user){
        System.out.println(user.getUsername() + "  " + user.getPassword());
        System.out.println(user.getEmail() + " " + user.getContact());
        return "Data Received";
    } 
    @GetMapping("/post/{id}")  
    public String getPostById(@PathVariable int id){
        System.out.println(id);
        return "Data Received";
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User u1 = new User(1, "Mukilan", "mukilan@gmail.com", "9876543210", "12345");
        User u2 = new User(2, "Manu", "manu@gmail.com", "9876543210", "12345");
        User u3 = new User(3, "Anbu", "anbu@gmail.com", "9876543210", "12345"); 
        List<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        User t = null;
        for(User u : users){
            if(u.getId() == id){
                t = u;
            }
        }
        return ResponseEntity.ok().body(t);

    }


}
/*
Path Variable

http://localhost:9000/post/13

 query parameter
    
    ?username=mukilan&password=12345&age=34
    name=value

    All the html forms submits the data using GET method
    and query params

 path variable
 body
 */
