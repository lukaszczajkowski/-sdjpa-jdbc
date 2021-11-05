package com.sfg.sdjpa.jdbc.repositories;

import com.sfg.sdjpa.jdbc.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
