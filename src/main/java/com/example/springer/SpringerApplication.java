package com.example.springer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@SpringBootApplication
@RestController
public class SpringerApplication {

    private final PersonRepository repository;

    public SpringerApplication(PersonRepository repository) {
        this.repository = repository;
    }

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


        String emptyString = "";
        for (PersonClass customer : repository.findAll()) {
            emptyString = emptyString +"\n"+customer.toString();
        }
        return emptyString;

    }
    @GetMapping(value = "/addPersonToDB")
    public List<PersonClass> personAdd() {
        repository.insert(new PersonClass("Can","Rollas"));
        return Collections.singletonList(repository.findByName("Can"));

    }
}
