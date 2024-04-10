package com.example.test.service;

import com.example.test.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final List<Person> persons = new ArrayList<>();


    @Override
    public Person createPerson(String id, String firstName, String lastName, String dateOfBirth) {
        Person person = new Person(id, firstName, lastName, dateOfBirth);
        persons.add(person);
        return person;
    }

    @Override
    public List<Person> getAllPersons() {
        return persons;
    }

    @Override
    public int checkPersonExistence(String id, String firstName, String lastName, String dateOfBirth) {
        return 0;
    }
}
