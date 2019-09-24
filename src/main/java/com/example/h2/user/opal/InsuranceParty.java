package com.example.h2.user.opal;

import javax.persistence.*;

@Entity
public class InsuranceParty {

    @EmbeddedId
    InsurancePartyPK insurancePartyPK;

    @ManyToOne
    @MapsId("fiId")
    FiEntity fiEntity;

    @ManyToOne
    @MapsId("personId")
    PersonEntity personEntity;


    public FiEntity getFiEntity() {
        return fiEntity;
    }

    public void setFiEntity(FiEntity fiEntity) {
        this.fiEntity = fiEntity;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    public InsurancePartyPK getInsurancePartyPK() {
        return insurancePartyPK;
    }

    public void setInsurancePartyPK(InsurancePartyPK insurancePartyPK) {
        this.insurancePartyPK = insurancePartyPK;
    }

    @Override
    public String toString() {
        return "insurance party "+fiEntity+", " + personEntity+", type="+insurancePartyPK.type;
    }
}
