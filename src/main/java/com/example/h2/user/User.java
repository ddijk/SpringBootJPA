package com.example.h2.user;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(onlyExplicitlyIncluded = true)
@Entity
@NamedQuery(query = "select u from User u", name = "query_find_all_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ToString.Include
    private String name;// Not perfect!! Should be a proper object!

//    @ToString.Include
//    private String role;// Not perfect!! An enum should be a better choice!

    protected User() {
    }

    public User(String name) {
        super();
        this.name = name;
//        this.role = role;
    }


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<Phone> phones = new ArrayList<>();

}
