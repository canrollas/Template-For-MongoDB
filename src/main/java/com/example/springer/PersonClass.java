package com.example.springer;
import org.springframework.data.annotation.Id;
import java.nio.charset.StandardCharsets;
import java.util.Random;


public class PersonClass {

    private String name;
    private  String surName;
    @Id
    private  String baseIdOfPerson;

    public PersonClass(String name, String surName) {
        this.name = name;
        this.surName = surName;
        this.baseIdOfPerson=setBaseIdOfPerson();
    }

    public String  setBaseIdOfPerson() {


        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 7;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }


    @Override
    public String toString(){
        return name+","+surName+","+baseIdOfPerson;
    }


}
