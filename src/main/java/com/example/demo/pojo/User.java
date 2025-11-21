package com.example.demo.pojo;


public class User {
    private Integer userId;
    private String name;
    private Integer bal;

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userId +
                ", username='" + name + '\'' +
                ", balance=" + bal +
                '}';
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBal() {
        return bal;
    }

    public void setBal(Integer bal) {
        this.bal = bal;
    }
}
