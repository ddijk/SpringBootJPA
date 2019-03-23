package com.example.h2.user;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@NamedQuery(query = "select u from User u", name = "query_find_all_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;// Not perfect!! Should be a proper object!

    private String role;// Not perfect!! An enum should be a better choice!

    protected User() {
    }

    public User(String name, String role) {
        super();
        this.name = name;
        this.role = role;
    }


}
