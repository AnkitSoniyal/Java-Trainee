package com.example.demo.entity;

import org.springframework.context.annotation.Primary;

public class Student {

    private int id;

    private String firstName;
    private String lastName;

    public Student() {}
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {

    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
