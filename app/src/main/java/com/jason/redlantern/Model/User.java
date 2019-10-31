package com.jason.redlantern.Model;

public class User {
    private String Name;
    private String Password;

    public User() {

    }

    public User(String name, String pass) {
        Name = name;
        Password = pass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
