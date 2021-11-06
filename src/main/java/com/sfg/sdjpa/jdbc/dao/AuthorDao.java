package com.sfg.sdjpa.jdbc.dao;

import com.sfg.sdjpa.jdbc.domain.Author;

public interface AuthorDao {

    Author getById(Long id);
}
