package com.example.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseBallCoach implements coach{
    public BaseBallCoach() {
        System.out.println("BaseBallCoach constructor called");
    }
    @Override
    public String getDailyWorkout() {
        return " Practice batting";
    }
}
