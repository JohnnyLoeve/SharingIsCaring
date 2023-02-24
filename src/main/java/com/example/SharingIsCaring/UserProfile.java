package com.example.SharingIsCaring;

import jakarta.persistence.*;

@Entity
public class UserProfile {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id of newUser
    @Column(name="name")
    private String name;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;



//do we need an empty constructor ?

    public UserProfile() {
    }

    public UserProfile(Long id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
