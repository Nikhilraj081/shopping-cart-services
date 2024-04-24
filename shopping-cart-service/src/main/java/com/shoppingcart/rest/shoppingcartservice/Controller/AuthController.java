package com.shoppingcart.rest.shoppingcartservice.Controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.rest.shoppingcartservice.Configuration.Constants;
import com.shoppingcart.rest.shoppingcartservice.Exceptions.ApiException;
import com.shoppingcart.rest.shoppingcartservice.Model.JwtRequest;
import com.shoppingcart.rest.shoppingcartservice.Model.JwtResponse;
import com.shoppingcart.rest.shoppingcartservice.Model.User;
import com.shoppingcart.rest.shoppingcartservice.Payload.UserDto;
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
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request)
    {
        JwtResponse response = authService.authenticate(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@Valid @RequestBody UserDto user) throws ApiException
    {
        User userDetails = userService.setUser(modelMapper.map(user,User.class),Constants.USER_ROLE);
      
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetails);
    }
}
