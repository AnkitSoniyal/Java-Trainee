package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private coach myCoach;
    public DemoController(){
        System.out.println("DemoController constructor called");
    }
    @Autowired
    public DemoController(@Qualifier("cricketCoach") coach theCoach) {
        myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
