package com.example.h2.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Phone {

    @GeneratedValue
    @Id
    @ToString.Include
    private int id;

    @ToString.Include
    private String nummer;
    @ToString.Include
    private String merk;

    public Phone() {
    }

    public Phone(String nummer, String merk) {
        this.nummer = nummer;
        this.merk = merk;
    }

    @ManyToOne
    @JsonIgnore
    private User user;


}
