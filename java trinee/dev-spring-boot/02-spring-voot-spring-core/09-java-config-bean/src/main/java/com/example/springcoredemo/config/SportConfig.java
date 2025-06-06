package com.example.springcoredemo.config;

import com.example.springcoredemo.common.SwimCoach;
import com.example.springcoredemo.common.coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public coach swimCoach(){
        return new SwimCoach();
    }
}
