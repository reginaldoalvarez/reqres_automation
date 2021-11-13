package com.appgate.regres.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class User {
    @JsonIgnore
    private int id;
    private String email;
    @JsonIgnore
    private String first_name;
    @JsonIgnore
    private String last_name;
    @JsonIgnore
    private String avatar;
    private String password;

    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(String email, String password,String first_name) {
        this.email = email;
        this.password = password;
        this.first_name=first_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String email){
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
