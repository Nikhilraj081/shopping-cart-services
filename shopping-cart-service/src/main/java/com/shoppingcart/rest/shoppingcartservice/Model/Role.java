package com.shoppingcart.rest.shoppingcartservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Role {

    @Id
    private int roleId;

    @NotEmpty(message = "role should not be empty")
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
