package com.example.h2.user;

import com.example.h2.user.opal.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepo extends JpaRepository<PersonEntity, Integer> {
}