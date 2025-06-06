package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private coach cricketCoach;
    private coach anotherCricketCoach;
    private coach baseBallCoach;
    private coach anotherbaseBallCoach;



    //DEFAULT SCOPE

    @Autowired
    public DemoController(@Qualifier("cricketCoach") coach theCoach,
                          @Qualifier("cricketCoach")coach theAnotherCoach,
                          @Qualifier("baseBallCoach")coach theBaseballCoach,
                          @Qualifier("baseBallCoach")coach theAnotherbaseballCoach


                          ) {
        System.out.println("In constructor "+getClass().getSimpleName());
        cricketCoach = theCoach;
        anotherCricketCoach = theAnotherCoach;
        baseBallCoach = theBaseballCoach;
        anotherbaseBallCoach = theAnotherbaseballCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return cricketCoach.getDailyWorkout();
    }

    @GetMapping("/check-default-bean")
    public String checkDefaultBean() {
        return "comparing bean: cricketCoach==anotherCricketCoach: "+(cricketCoach==anotherCricketCoach);
    }

    //PROTOTYPE SCOPE

    @GetMapping("/check-prototype")
    public String checkPrototype() {
        return "comparing bean: baseBallCoach==anotherbaseBallCoach: "+(baseBallCoach==anotherbaseBallCoach);
    }



}
