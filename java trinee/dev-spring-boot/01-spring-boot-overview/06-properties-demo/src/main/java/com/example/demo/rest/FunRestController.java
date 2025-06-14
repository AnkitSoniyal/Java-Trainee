package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //inject properties
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    //EXPOSE NEW ENDPOINT
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach:"+coachName+",Team:"+teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
    //expose a new endpoint
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Workout";
    }

    @GetMapping("/fortune")
    public String getFortune(){
        return "Fortune";
    }
}
