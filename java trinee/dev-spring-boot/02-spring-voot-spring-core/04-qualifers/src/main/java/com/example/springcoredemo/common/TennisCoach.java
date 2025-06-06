package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements coach {
    @Override
    public String getDailyWorkout() {
        return " Practice backhand volley";
    }
}
