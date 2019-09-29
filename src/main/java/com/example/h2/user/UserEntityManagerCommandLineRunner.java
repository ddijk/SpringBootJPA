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
    private UserRepository userRepository;

    @Autowired
    PhoneRepository phoneRepository;


    @Override
    public void run(String... args) {

//        createData();
    }

    private void createData() {
        log.info("-------------------------------");
        log.info("Adding Tom as Admin");
        log.info("-------------------------------");
        User tom = new User("Tom");
        Phone p1 = new Phone("123", "Apple");
        Phone p2 = new Phone("222", "Samsung");
        p1.setUser(tom);
        p2.setUser(tom);
        tom.setPhones(List.of(p1, p2));
        userRepository.save(tom);
//        List<Phone> phones = phoneRepository.saveAll(List.of(p1, p2));

//        userRepository.save(tom);
//        tom = userService.find(tomId);

//
//        userService.merge(tom);

        log.info("Inserted Tom" + tom);


        log.info("-------------------------------");
        log.info("Finding all users");
        log.info("-------------------------------");
        log.info(userRepository.findAll().toString());
    }
}
