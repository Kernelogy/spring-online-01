package com.edex.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "addresses")
@Entity
public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String plotNo;
    private String street;
    private String landmark;
    private String city;
    private String state;
    private String country;
    private String pincode;
    // @OneToOne(mappedBy = "address")
    // private User user;

    public Address(){}
    public Address(int id, String plotNo, String street, String landmark, String city, String state, String country,
            String pincode) {
        this.id = id;
        this.plotNo = plotNo;
        this.street = street;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPlotNo() {
        return plotNo;
    }
    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getLandmark() {
        return landmark;
    }
    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPincode() {
        return pincode;
    }
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    // public User getUser() {
    //     return user;
    // }
    // public void setUser(User user) {
    //     this.user = user;
    // }

    
}
