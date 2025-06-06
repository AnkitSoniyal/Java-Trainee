package com.Security.SpringSecEx.model;

import lombok.Data;

@Data
public class student {
    private String name;
    private int id;
    private int marks;

    public  student( int id,String name, int marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public String toString(){
        return "Name: " + name + ", Id: " + id + ", Marks: " + marks;
    }


}
