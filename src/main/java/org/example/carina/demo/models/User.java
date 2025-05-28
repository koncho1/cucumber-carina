package org.example.carina.demo.models;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String zipCode;
}
