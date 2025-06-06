package com.example.first.spring.repository;

import com.example.first.spring.entity.jounralEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface entryRepository extends MongoRepository<jounralEntry, ObjectId> {
}
