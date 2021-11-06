package com.sfg.sdjpa.jdbc.dao;

import com.sfg.sdjpa.jdbc.domain.Book;

public interface BookDao {

    Book getById(Long id);

    Book getByTitle(String title);

    Book saveNewBook(Book book);

    Book updateBook(Book book);

    void deleteById(Long id);
}
