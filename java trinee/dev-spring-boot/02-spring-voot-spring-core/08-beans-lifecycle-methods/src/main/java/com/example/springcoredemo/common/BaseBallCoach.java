package com.example.springcoredemo.common;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements coach{
    public BaseBallCoach() {
        System.out.println("BaseBallCoach constructor called");
    }
    @Override
    public String getDailyWorkout() {
        return " Practice batting";
    }
}
