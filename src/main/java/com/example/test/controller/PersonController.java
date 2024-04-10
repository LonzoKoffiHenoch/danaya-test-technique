package com.example.test.controller;

import com.example.test.model.Person;
import com.example.test.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person createPerson(
            @RequestParam String id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String dateOfBirth
    ) {
        return personService.createPerson(id, firstName, lastName, dateOfBirth);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

}