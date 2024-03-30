package com.shoppingcart.rest.shoppingcartservice.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.shoppingcart.rest.shoppingcartservice.Model.JwtRequest;
import com.shoppingcart.rest.shoppingcartservice.Model.JwtResponse;
import com.shoppingcart.rest.shoppingcartservice.Security.JwtHelper;

@Service
public class AuthService {

    private Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    JwtResponse response;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    public JwtResponse authenticate(JwtRequest request)
    {
        logger.info("Authenticating user id and password");
        this.doAuthenticate(request.getEmail(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        logger.info("Generating JWT token");
        String token = this.helper.generateToken(userDetails);

        response.setJwtToken(token);
        response.setUserName(userDetails.getUsername());
        logger.info("Token generated");
        return response;
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }

}
