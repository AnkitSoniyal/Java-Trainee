package com.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements coach {
    public TennisCoach() {
        System.out.println("TennisCoach constructor called");
    }
    @Override
    public String getDailyWorkout() {
        return " Practice backhand volley";
    }
}
