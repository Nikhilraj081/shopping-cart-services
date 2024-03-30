package com.shoppingcart.rest.shoppingcartservice.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.shoppingcart.rest.shoppingcartservice.Configuration.Constants;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ApiException;
import com.shoppingcart.rest.shoppingcartservice.Model.JwtRequest;
import com.shoppingcart.rest.shoppingcartservice.Model.JwtResponse;
import com.shoppingcart.rest.shoppingcartservice.Model.User;
import com.shoppingcart.rest.shoppingcartservice.Security.JwtHelper;
import com.shoppingcart.rest.shoppingcartservice.Services.AuthService;
import com.shoppingcart.rest.shoppingcartservice.Services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request)
    {
        JwtResponse response = authService.authenticate(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@Valid @RequestBody User user) throws ApiException
    {
        User userDetails = userService.setUser(user,Constants.USER_ROLE);
      
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
    }
}
