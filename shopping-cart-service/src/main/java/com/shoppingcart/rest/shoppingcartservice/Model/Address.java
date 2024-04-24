package com.shoppingcart.rest.shoppingcartservice.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    @NotEmpty(message = "Phone no should not be empty")
    private String phoneNo;;

    @NotNull(message = "Pincode should not be empty")
    private int pinCode;

    @NotEmpty(message = "State should not be empty")
    private String state;

    @NotEmpty(message = "City should not be empty")
    private String city;

    @NotEmpty(message = "Area should not be empty")
    private String area;

    @ManyToOne
    @JsonBackReference(value = "address-user")
    private User user;

    @NotEmpty(message = "Name should not be empty")
    private String addressType;

    public Address(int addressId, String name, String phoneNo, int pinCode, String state, String city, String area,
            User user, String addressType) {
        this.addressId = addressId;
        this.name = name;
        this.phoneNo = phoneNo;
        this.pinCode = pinCode;
        this.state = state;
        this.city = city;
        this.area = area;
        this.user = user;
        this.addressType = addressType;
    }

    public Address() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
}
