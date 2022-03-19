package com.example.springer;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface PersonRepository extends MongoRepository<PersonClass, String> {

    public PersonClass findByName(String name);
    public PersonClass findBySurName(String surName);
    public PersonClass findByBaseIdOfPerson(String baseIdOfPerson);
}