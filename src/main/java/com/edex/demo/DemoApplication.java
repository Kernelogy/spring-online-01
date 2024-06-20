package com.edex.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication.run(DemoApplication.class, args);
	}
}
/*
 http://localhost:8080/sayHello => URL (we can place request to the server)

 Rest Services

HTTP Request
	GET
	POST
	PUT
	DELETE
	PATCH
	OPTIONS

	

 */