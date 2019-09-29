package com.example.h2.user.rest;

import com.example.h2.user.Phone;
import com.example.h2.user.PhoneRepository;
import com.example.h2.user.User;
import com.example.h2.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    UserRepository userRepository;

    @DeleteMapping("/{merk}")
    ResponseEntity delete(@PathVariable String merk) {

        final List<Phone> byMerk = phoneRepository.findByMerk(merk);

        System.out.println("Found phones: " + byMerk);


        byMerk.forEach(p-> p.getUser().getPhones().remove(p));
        byMerk.forEach(phoneRepository::delete);

        return ResponseEntity.ok("phone deleted");
    }

    @PostMapping("/{username}")
    ResponseEntity addPhoneToUser(@PathVariable String username, @RequestBody Phone phone) {

        User user = userRepository.findByName(username);

        user.getPhones().add(phone);
        phone.setUser(user);

      user =  userRepository.save(user);

        System.out.println(String.format("Add phone %s to user %s ",phone, username));

        return ResponseEntity.ok(user);
    }
}
