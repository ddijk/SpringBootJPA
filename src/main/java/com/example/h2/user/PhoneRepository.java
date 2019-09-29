package com.example.h2.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    List<Phone> findByMerk(String merk);

}
