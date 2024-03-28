package com.shoppingcart.rest.shoppingcartservice.Model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class JwtRequest {

    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @NotEmpty
    @Size(min = 8, max = 16, message = "Password length should be between 8 to 16 character")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}