package com.leandro.person.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.leandro.person.encrypt.AttributeEncryptor;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String dateOfBirth;

    @Column
    @Convert(converter = AttributeEncryptor.class)
    private String motherName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    @JsonManagedReference
    private List<Document> documents;


}
