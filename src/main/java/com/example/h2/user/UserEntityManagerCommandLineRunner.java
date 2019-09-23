package com.example.h2.user;

import com.example.h2.user.opal.FiEntity;
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

//    @Autowired
//    private UserRepository userRepository;

    @Override
    public void run(String... args) {

        log.info("-------------------------------");
        log.info("Adding Tom as Admin");
        log.info("-------------------------------");

        FiEntity f1 = new FiEntity();
        f1.setId(1);
        f1.setNaam("interpolis");

        List<FiEntity> phones = phoneRepository.saveAll(List.of( f1));
        System.out.println("Save phones: " + phones);

//        userRepository.save(tom);
//        tom = userService.find(tomId);

//
//        userService.merge(tom);

//        log.info("Inserted Tom" + tom);

        log.info("-------------------------------");
        log.info("Finding user with id 1");
        log.info("-------------------------------");
//        User user = userService.find(1L);
//        log.info(user.toString());

    }
}
