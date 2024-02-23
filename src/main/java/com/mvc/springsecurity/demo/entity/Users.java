package com.mvc.springsecurity.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Users {
    @Id
    @Column(name="username")
    private String username;

    private String password;
    private int enabled;

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public Users(String username, String password, int enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
