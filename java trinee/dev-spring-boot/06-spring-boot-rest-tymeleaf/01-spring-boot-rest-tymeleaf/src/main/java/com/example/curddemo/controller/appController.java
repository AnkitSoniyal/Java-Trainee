package com.example.curddemo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/hello")
public class appController {
    @GetMapping
    public String showForm() {
        return "hello";//SHOW hello.html form
    }

    @PostMapping
    public String processForm(@RequestParam("name") String name, Model model) {
        String result = "hello "+name;
        model.addAttribute("result",result);
        return "hello";
    }

}
