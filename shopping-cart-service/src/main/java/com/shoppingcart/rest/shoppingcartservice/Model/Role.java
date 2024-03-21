package com.shoppingcart.rest.shoppingcartservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Role {

    @Id
    private int roleId;
    private String role;
    
    public Role(int roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public Role() {
    }

    @JsonIgnore
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
