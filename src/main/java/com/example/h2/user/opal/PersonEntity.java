package com.example.h2.user.opal;

import javax.persistence.Entity;

@Entity
public class PersonEntity {

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
}
