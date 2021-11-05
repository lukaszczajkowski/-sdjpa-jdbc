package com.sfg.sdjpa.jdbc.repositories;

import com.sfg.sdjpa.jdbc.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
