package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements coach {
    public CricketCoach() {
        System.out.println("CricketCoach constructor called");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling";
    }

}
