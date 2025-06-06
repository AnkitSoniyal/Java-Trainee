package com.example.first.spring.controller;

import com.example.first.spring.entity.User;
import com.example.first.spring.entity.jounralEntry;
import com.example.first.spring.service.UserEntryService;
import com.example.first.spring.service.entryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ec")
public class entrycontrollerv2 {
    @Autowired
    private entryService entryServices;

    @Autowired
    private UserEntryService userEntryServices;


    @GetMapping
    public ResponseEntity<?> getAllJournalEntries() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User user= UserEntryService.findByUserName(userName);
        List<jounralEntry> all=user.getJounralEntryList();
        if(all.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<jounralEntry> create(@RequestBody jounralEntry entry) {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username=authentication.getName();
            entryServices.saveEntry(entry,username);
            return new ResponseEntity<>(entry,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }

    }


    @GetMapping("/id/{myId}")
    public ResponseEntity<jounralEntry> getEntryByTheId(@PathVariable ObjectId myId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User user=UserEntryService.findByUserName(userName);

       List<jounralEntry>collect=user.getJounralEntryList().stream().filter(x->x.getId().equals(myId)).collect(Collectors.toList());
       if(collect.isEmpty()){
           Optional<jounralEntry> entry = entryServices.getEntryById(myId);
            if(entry.isPresent()){
                return new ResponseEntity<>(HttpStatus.OK);
            }

       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteTheEntry(@PathVariable ObjectId myId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        entryServices.deleteEntry(myId,userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/id/{myId}/{username}")
    public ResponseEntity<?> updateEntry(@PathVariable ObjectId myId,
                                         @PathVariable String username,
                                         @RequestBody jounralEntry newentry) {
        jounralEntry e=entryServices.getEntryById(myId).orElse(null);

        if(e!=null){
            e.setContent(newentry.getContent()!=null && newentry.getContent().length()>0?newentry.getContent():e.getContent());
            e.setTitle(newentry.getTitle()!=null && newentry.getTitle().length()>0?newentry.getTitle():e.getTitle());
            entryServices.saveEntry(e, username);
            return new ResponseEntity<>(e,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
