package com.shoppingcart.rest.shoppingcartservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shoppingcart.rest.shoppingcartservice.Model.User;
import com.shoppingcart.rest.shoppingcartservice.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity <User> getUserById(@PathVariable("id") int id)
    {
        User user = userService.getUserById(id);
       if(user == null)
       {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       
       return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/user")
    public ResponseEntity <?> SetUser(@RequestBody User user)
    {
        User userDetails = userService.SetUser(user);

        if(userDetails == null)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Body is not valid");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("User data updated successfully");

    }

}
