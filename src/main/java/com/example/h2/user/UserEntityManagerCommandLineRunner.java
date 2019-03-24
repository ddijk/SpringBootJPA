package com.example.h2.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserEntityManagerCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserEntityManagerCommandLineRunner.class);

    @Autowired
    private UserService userService;

    @Autowired
    PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {

        log.info("-------------------------------");
        log.info("Adding Tom as Admin");
        log.info("-------------------------------");
        User tom = new User("Tom", "Admin");
        Phone p1 = new Phone("123", "Apple");
        Phone p2 = new Phone("222", "Samsung");

        List<Phone> phones = phoneRepository.saveAll(List.of(p1, p2));
        System.out.println("Save phones: " + phones);
        tom.setPhones(Map.of(phones.get(0).getId(), p1, phones.get(1).getId(), p2));
        p1.setUser(tom);
        p2.setUser(tom);
        userService.merge(tom);

//        userRepository.save(tom);
//        tom = userService.find(tomId);

//
//        userService.merge(tom);

        log.info("Inserted Tom" + tom);

        log.info("-------------------------------");
        log.info("Finding user with id 1");
        log.info("-------------------------------");
        User user = userService.find(1L);
//        log.info(user.toString());

        log.info("-------------------------------");
        log.info("Finding all users");
        log.info("-------------------------------");
        log.info(userService.findAll().toString());
    }
}
