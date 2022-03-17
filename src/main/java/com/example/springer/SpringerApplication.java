package com.example.springer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@RestController
public class SpringerApplication {

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringerApplication.class, args);
    }

    @GetMapping(value = "/")
    public Map<String,String> returnerMap(){
        HashMap<String,String> myMap = new HashMap<>();
        myMap.put("Ankara","Rollas");
        return myMap;
    }
    @GetMapping(value = "/addQuery")
    public String dataValueAdd() {

        repository.insert(new PersonClass("Mert","Karaca"));
        repository.insert(new PersonClass("Cagatay","Iba"));
        repository.insert(new PersonClass("Umutcan","Ceyhan"));



        String emptyString = "";
        for (PersonClass customer : repository.findAll()) {
            emptyString = emptyString +"\n"+customer.toString();
        }
        return emptyString;

    }
}
