package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements coach{
    @Override
    public String getDailyWorkout() {
        return " Practice batting";
    }
}
