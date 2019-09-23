package com.example.h2.user;

import com.example.h2.user.opal.FiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PhoneRepository extends JpaRepository<FiEntity, Integer> {
}
