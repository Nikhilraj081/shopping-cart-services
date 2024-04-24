package com.shoppingcart.rest.shoppingcartservice.Payload;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.shoppingcart.rest.shoppingcartservice.Model.Address;
import com.shoppingcart.rest.shoppingcartservice.Model.Cart;
import com.shoppingcart.rest.shoppingcartservice.Model.Role;
import com.shoppingcart.rest.shoppingcartservice.Model.WishList;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

public class UserDto {

    private int userId;
   
    private String userName;

    private String userMobileNo;

    private String userEmailId;

    @Schema(accessMode = AccessMode.WRITE_ONLY)
    @JsonIgnore
    private String userPassword;


    @Schema(accessMode = AccessMode.READ_ONLY)
    private Set<Role> roles = new HashSet<>();

    @Schema(accessMode = AccessMode.READ_ONLY)
    private List<AddressDto> address;


    public UserDto() {
    }


    public UserDto(int userId, String userName, String userMobileNo, String userEmailId, String userPassword,
            Set<Role> roles, List<AddressDto> address) {
        this.userId = userId;
        this.userName = userName;
        this.userMobileNo = userMobileNo;
        this.userEmailId = userEmailId;
        this.userPassword = userPassword;
        this.roles = roles;
        this.address = address;
    }


    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserMobileNo() {
        return userMobileNo;
    }


    public void setUserMobileNo(String userMobileNo) {
        this.userMobileNo = userMobileNo;
    }


    public String getUserEmailId() {
        return userEmailId;
    }


    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }


    public String getUserPassword() {
        return userPassword;
    }


    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public Set<Role> getRoles() {
        return roles;
    }


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public List<AddressDto> getAddress() {
        return address;
    }


    public void setAddress(List<AddressDto> address) {
        this.address = address;
    }

    
}
