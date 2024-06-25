package com.edex.demo.model;

//jpa dependency contains the below classes
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//POJO(Plain Old Java Object) Class
@Entity
@Table(name = "users")  //using the table names in plural is a standar
public class User{
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String email;
    private String contact;
    private String password; 
    
    public User(int id, String username, 
                String email, String contact, 
                String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.contact = contact;
        this.password = password;

    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setUserName(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setContact(String contact){
        this.contact = contact;
    }
    public String getContact(){
        return contact;
    }

}
