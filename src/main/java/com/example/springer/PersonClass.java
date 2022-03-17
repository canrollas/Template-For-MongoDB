package com.example.springer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class PersonClass {
    @Id
    private String name;

    private String surName;

    public PersonClass(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    @Override
    public String toString(){
        return name+","+surName;
    }
}
