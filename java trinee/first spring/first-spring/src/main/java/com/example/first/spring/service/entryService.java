package com.example.first.spring.service;

import com.example.first.spring.entity.User;
import com.example.first.spring.entity.jounralEntry;
import com.example.first.spring.repository.entryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class entryService {
    @Autowired
    private entryRepository entryRepositories;
    @Autowired
    private UserEntryService userEntryService;
    @Transactional
    public void saveEntry(jounralEntry entry, String user) {
        try{
            User use= UserEntryService.findByUserName(user);
            entry.setDate(LocalDateTime.now());
            jounralEntry e =entryRepositories.save(entry);
            use.getJounralEntryList().add(e);
            userEntryService.saveNewEntry(use);

        }catch (Exception e){
          log.error("Error saving entry",e);
        }
    }

    public void saveEntry(jounralEntry entry){
        entryRepositories.save(entry);
    }

    public List<jounralEntry> getAll() {
        return entryRepositories.findAll();
    }

    public Optional<jounralEntry> getEntryById(ObjectId id) {
        return entryRepositories.findById(id);
    }

    public void deleteEntry(ObjectId entry,String user) {
        User use= UserEntryService.findByUserName(user);
        use.getJounralEntryList().removeIf(jounralEntry -> jounralEntry.getId().equals(entry));
        entryRepositories.deleteById(entry);
    }

    public Optional<jounralEntry> updateEntry(ObjectId entry,jounralEntry entry1) {
        return entryRepositories.findById(entry);
    }

}
