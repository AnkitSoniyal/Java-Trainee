package com.example.first.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Myclass {
    @GetMapping("aaa")
    public String sayHello(){
        return "Hello World";
    }

}
