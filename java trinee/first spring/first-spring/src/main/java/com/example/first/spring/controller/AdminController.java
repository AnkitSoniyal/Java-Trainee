package com.example.first.spring.controller;
import com.example.first.spring.entity.User;
import com.example.first.spring.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
   @Autowired
   public UserEntryService userEntryService;

   @GetMapping("/all")
   public ResponseEntity<List<User>> getAllUsers(){
       List<User> all=userEntryService.allEntries();
       if (all!=null && !all.isEmpty()){
           return new ResponseEntity<>(all, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @PostMapping("/create-admin-userr")
    public void createUser(@RequestBody User user){
       userEntryService.saveEntry(user);
   }
}
