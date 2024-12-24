package com.coen.demo.models;

import jakarta.persistence.*;

@Table(name = "authors")
@Entity
public class Author {
    @Id
    @GeneratedValue
    private int Id;
    @Column(name = "username")
    private String username;
    @Column( name ="email", unique = true)
    private String email;
    @Column(name="password")
    private String password;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
