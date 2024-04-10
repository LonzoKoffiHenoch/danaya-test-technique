package com.example.test.service;

import com.example.test.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonServiceTest {

    @InjectMocks
    private PersonServiceImpl personService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreatePerson() {
        // Given
        String id = "1";
        String firstName = "John";
        String lastName = "Doe";
        String dateOfBirth = "1990-01-01";
        Person person = new Person(id, firstName, lastName, dateOfBirth);

        Person createdPerson = personService.createPerson(person);

        List<Person> persons = personService.getAllPersons();
        assertEquals(1, persons.size());
        assertTrue(persons.contains(createdPerson));
    }

    @Test
    public void testGetAllPersons() {
        // Given
        String id = "1";
        String firstName = "John";
        String lastName = "Doe";
        String dateOfBirth = "1990-01-01";
        Person person = new Person(id, firstName, lastName, dateOfBirth);

        personService.createPerson(person);

        // When
        List<Person> persons = personService.getAllPersons();

        // Then
        assertEquals(1, persons.size());
    }
}
