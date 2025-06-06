package com.example.first.spring.repository;

import com.example.first.spring.entity.User;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserEntryRepository extends MongoRepository<User, ObjectId> {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    void deleteByUsername(String username);
}
