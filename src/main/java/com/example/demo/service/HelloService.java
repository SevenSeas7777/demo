package com.example.demo.service;

public class HelloService {
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public HelloService() {
    }

    public HelloService(String firstname) {
        this.firstname = firstname;
    }
}
