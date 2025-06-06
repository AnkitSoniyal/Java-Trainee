package com.example.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling";
    }

}
