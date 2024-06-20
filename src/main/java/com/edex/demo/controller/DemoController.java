package com.edex.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    
}
/*
 query parameter
    
    ?username=mukilan&password=12345&age=34
    name=value

    All the html forms submits the data using GET method
    and query params

 path variable
 body
 */
