package com.example.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements coach {
    public CricketCoach() {
        System.out.println("CricketCoach constructor called ");
    }
    //DEFINE OUR INIT METHOD
    @PostConstruct
    public void doSomething() {
        System.out.println("CricketCoach doSomething called "+getClass().getSimpleName());
    }

    // DEFINE OUR DESTROY METHOD
    @PreDestroy
    public void doCleaning() {
        System.out.println("CricketCoach doCleaning called"+getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling";
    }

}
