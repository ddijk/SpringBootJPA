package com.example.h2.user.rest;

import com.example.h2.user.User;
import com.example.h2.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {

        final User user = userRepository.findById(Long.valueOf(id)).get();

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        final List<User> users = userRepository.findAll();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/{name}")
    public ResponseEntity<User> createUser(@PathVariable String name) {

        User user = new User(name);
        user = userRepository.save(user);
        return ResponseEntity.ok(user);

    }

    @DeleteMapping("/{name}")
    public ResponseEntity<User> deleteUser(@PathVariable("name") String name) {

        User user = userRepository.findByName(name);

        userRepository.delete(user);
        return ResponseEntity.ok(user);

    }
}
