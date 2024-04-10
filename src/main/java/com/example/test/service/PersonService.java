package com.example.test.service;

import com.example.test.model.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);

    List<Person> getAllPersons();

    int checkPersonExistence(String id, String firstName, String lastName, String dateOfBirth);
}
