package com.example.test.controller;

import com.example.test.model.Person;
import com.example.test.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @Test
    public void testCreatePerson() throws Exception {
        // Given
        String id = "1";
        String firstName = "John";
        String lastName = "Doe";
        String dateOfBirth = "1990-01-01";
        Person person = new Person(id, firstName, lastName, dateOfBirth);
        when(personService.createPerson(person)).thenReturn(person);

        // When/Then
        mockMvc.perform(post("/api/persons")
                        .param("id", id)
                        .param("firstName", firstName)
                        .param("lastName", lastName)
                        .param("dateOfBirth", dateOfBirth)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)) // Ajouter accept pour spécifier le type de contenu accepté
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.firstName").value(firstName))
                .andExpect(jsonPath("$.lastName").value(lastName))
                .andExpect(jsonPath("$.dateOfBirth").value(dateOfBirth))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void testGetAllPersons() throws Exception {
        // Given
        String id = "1";
        String firstName = "John";
        String lastName = "Doe";
        String dateOfBirth = "1990-01-01";
        Person person = new Person(id, firstName, lastName, dateOfBirth);
        when(personService.getAllPersons()).thenReturn(Collections.singletonList(person));

        // When/Then
        mockMvc.perform(get("/api/persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(id))
                .andExpect(jsonPath("$[0].firstName").value(firstName))
                .andExpect(jsonPath("$[0].lastName").value(lastName))
                .andExpect(jsonPath("$[0].dateOfBirth").value(dateOfBirth));
    }
}