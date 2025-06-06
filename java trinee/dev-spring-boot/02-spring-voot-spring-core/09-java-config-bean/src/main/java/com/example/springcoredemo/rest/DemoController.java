package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private coach cricketCoach;


    //DEFAULT SCOPE

    @Autowired
    public DemoController(@Qualifier("swimCoach") coach theCoach
                          ) {
        System.out.println("In constructor "+getClass().getSimpleName());
        cricketCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return cricketCoach.getDailyWorkout();
    }


}
