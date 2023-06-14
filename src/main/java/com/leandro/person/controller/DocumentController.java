package com.leandro.person.controller;

import com.leandro.person.entity.Document;
import com.leandro.person.entity.Person;
import com.leandro.person.repository.DocumentRepository;
import com.leandro.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
@AllArgsConstructor
public class DocumentController {

    private final PersonRepository personRepository;
    private final DocumentRepository documentRepository;

    @PostMapping("/person/{personId}")
    public ResponseEntity<Document> createDocument(@PathVariable Long personId, @RequestBody Document document) {

        Person person = personRepository.findById(personId).orElse(null);
        if (person != null) {
            document.setPerson(person);
            Document createdDocument = documentRepository.save(document);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
