package com.example.first.spring.service;

import com.example.first.spring.entity.User;
import com.example.first.spring.entity.jounralEntry;
import com.example.first.spring.repository.UserEntryRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Slf4j
@Component
public class UserEntryService {
    private static UserEntryRepository entryRepositories = null;

    private final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public UserEntryService(UserEntryRepository entryRepositories) {
        this.entryRepositories = entryRepositories;
    }

    public List<User> allEntries() {
        return entryRepositories.findAll();
    }
    public void saveNewEntry(User entry) {
        entry.setPassword(passwordEncoder.encode(entry.getPassword()));
        entry.setRoles(List.of("USER"));
        entryRepositories.save(entry);
    }

    public void saveAdmin(User entry) {
        entry.setPassword(passwordEncoder.encode(entry.getPassword()));
        entry.setRoles(List.of("USER","ADMIN"));
        entryRepositories.save(entry);
    }

    public void saveEntry(User entry) {
  // encode password
        entryRepositories.save(entry);
    }

    public User findByUserName(String username,String password) {
        return entryRepositories.findByUsernameAndPassword(username,password);
    }

    public static User findByUserName(@NonNull String username) {
        return entryRepositories.findByUsername(username);
    }


}
