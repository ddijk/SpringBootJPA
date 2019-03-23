package com.example.h2.user.rest;

import com.example.h2.user.User;
import com.example.h2.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/aap")
    public ResponseEntity<User> getUser() {

        User user = new User("dick", "developer") ;

        userService.insert(user);

        System.out.println("User inserted "+ user);

        return ResponseEntity.ok(user);
    }
}
