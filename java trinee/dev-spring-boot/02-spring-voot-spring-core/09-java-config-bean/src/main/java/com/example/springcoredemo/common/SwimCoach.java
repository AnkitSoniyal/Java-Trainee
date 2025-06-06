package com.example.springcoredemo.common;

public class SwimCoach implements coach{
    public  SwimCoach() {
        System.out.println("SwimCoach constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "swim 1000 meters";
    }
}
