package com.sfg.sdjpa.jdbc.dao;

import com.sfg.sdjpa.jdbc.domain.Author;

public interface AuthorDao {

    Author getById(Long id);

    Author getByName(String name);

    Author saveNewAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteById(Long id);
}
