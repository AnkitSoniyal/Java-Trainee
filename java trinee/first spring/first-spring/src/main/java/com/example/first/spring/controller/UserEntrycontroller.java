package com.example.first.spring.controller;

import com.example.first.spring.entity.User;
import com.example.first.spring.repository.UserEntryRepository;
import com.example.first.spring.service.UserEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserEntrycontroller {
    @Autowired
    UserEntryRepository userEntryRepository;
    @Autowired
    UserEntryService entryServices;

    public UserEntrycontroller(UserEntryService entryServices, UserEntryService userEntryService) {
        this.entryServices = entryServices;
    }


    @PutMapping
    public ResponseEntity<?> updateEntryByName(@RequestBody User entry) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User user= UserEntryService.findByUserName(userName);
            user.setPassword(entry.getPassword());
            user.setUsername(entry.getUsername());
            entryServices.saveNewEntry(user);
            return new ResponseEntity<>(entry, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<?> deleteEntryByName(@RequestParam String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User user= UserEntryService.findByUserName(username);
        userEntryRepository.deleteByUsername(authentication.getName());
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
