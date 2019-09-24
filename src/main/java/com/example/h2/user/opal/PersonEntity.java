package com.example.h2.user.opal;

import javax.persistence.*;
import java.util.List;

@Entity
public class PersonEntity {

    @Id
    int id;
    String naam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @OneToMany
    @JoinColumn(name="PERSON_ID")
    List<InsuranceParty> insurancePartyList;

    @Override
    public String toString() {
        return "Person met id "+ id;
    }
}
