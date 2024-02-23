package com.mvc.springsecurity.demo.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Authorities {
    @Id
    private String username;
    private String authority;
    @ManyToOne
    @JoinColumn(name = "username")
    private Users users;

    public Authorities() {
    }

    public Authorities(String username, String authority, Users users) {
        this.username = username;
        this.authority = authority;
        this.users = users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
