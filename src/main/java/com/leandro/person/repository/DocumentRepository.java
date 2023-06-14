package com.leandro.person.repository;

import com.leandro.person.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
