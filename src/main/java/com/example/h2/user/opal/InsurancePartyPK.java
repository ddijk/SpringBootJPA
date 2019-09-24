package com.example.h2.user.opal;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class InsurancePartyPK  implements Serializable {

    int fiId;
    int personId;

    String type;

    public int getFiId() {
        return fiId;
    }

    public void setFiId(int fiId) {
        this.fiId = fiId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
