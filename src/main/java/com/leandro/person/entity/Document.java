package com.leandro.person.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.leandro.person.encrypt.AttributeEncryptor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    @Convert(converter = AttributeEncryptor.class)
    private String value;

    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;


}
