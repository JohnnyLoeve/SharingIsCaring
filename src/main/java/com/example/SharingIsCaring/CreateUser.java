package com.example.SharingIsCaring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CreateUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id of newUser
    private String username;
    private String password;

    //do we need an empty constructor ?

    public CreateUser(){

    }
    public CreateUser(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
