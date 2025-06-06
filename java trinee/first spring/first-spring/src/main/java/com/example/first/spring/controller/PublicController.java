package com.example.first.spring.controller;

import com.example.first.spring.entity.User;
import com.example.first.spring.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    UserEntryService userEntryService;
    @GetMapping("/health-check")
    public String HealthCheck() {
        return "ok";
    }
    @PostMapping("/create-user")
    public void create(@RequestBody User user){
        userEntryService.saveNewEntry(user);
    }
}
