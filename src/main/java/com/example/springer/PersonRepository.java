package com.example.springer;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<PersonClass, String> {

    public PersonClass findByName(String name);
    public PersonClass findBySurName(String surName);
}