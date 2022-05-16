package com.example.poc.mongocustomizedkey.repository;

import com.example.poc.mongocustomizedkey.model.Day;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends MongoRepository<Day, String> {
}
