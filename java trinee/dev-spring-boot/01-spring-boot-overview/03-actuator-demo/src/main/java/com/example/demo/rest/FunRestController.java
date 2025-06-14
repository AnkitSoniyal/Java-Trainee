package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
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
