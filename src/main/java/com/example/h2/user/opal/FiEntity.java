package com.example.h2.user.opal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class FiEntity {

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

    @OneToMany(mappedBy = "insurancePartyPK.fiId")
    List<InsuranceParty> insurancePartyList;

    @Override
    public String toString() {
        return "Fi met id "+ id;
    }
}
