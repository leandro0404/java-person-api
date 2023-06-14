package com.leandro.person.controller;

import com.leandro.person.entity.Person;
import com.leandro.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personRepository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }
}
