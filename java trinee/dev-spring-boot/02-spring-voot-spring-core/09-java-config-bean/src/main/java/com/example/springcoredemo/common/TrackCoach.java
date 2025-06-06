package com.example.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements coach{
    public TrackCoach() {
        System.out.println("TrackCoach constructor called");
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}

