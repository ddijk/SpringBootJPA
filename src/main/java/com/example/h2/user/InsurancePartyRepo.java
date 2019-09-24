package com.example.h2.user;

import com.example.h2.user.opal.InsuranceParty;
import com.example.h2.user.opal.InsurancePartyPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface InsurancePartyRepo extends JpaRepository<InsuranceParty, InsurancePartyPK> {
}
