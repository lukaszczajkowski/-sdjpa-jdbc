package com.sfg.sdjpa.jdbc;

import com.sfg.sdjpa.jdbc.dao.BookDao;
import com.sfg.sdjpa.jdbc.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = "com.sfg.sdjpa.jdbc.dao")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookDaoIntegrationTest {

    @Autowired
    BookDao bookDao;

    @Test
    void shouldGetBookById() {
        Book book = bookDao.getById(1L);

        assertThat(book).isNotNull();
    }

    @Test
    void shouldGetBookByTitle() {
        Book book = bookDao.getByTitle("Clean Code");

        assertThat(book.getTitle()).isEqualTo("Clean Code");
    }

    @Test
    void shouldSaveBook() {
        Book book = new Book();
        book.setTitle("title");
        Book saved = bookDao.saveNewBook(book);

        assertThat(saved).isNotNull();
    }

    @Test
    void shouldUpdateBook() {
        Book book = new Book();
        book.setTitle("title");
        Book saved = bookDao.saveNewBook(book);

        saved.setTitle("Malecka1");
        Book updated = bookDao.updateBook(saved);

        assertThat(updated.getTitle()).isEqualTo("Malecka1");
    }

    @Test
    void shouldDeleteBook() {
        Book book = new Book();
        book.setTitle("title");
        Book saved = bookDao.saveNewBook(book);

        bookDao.deleteById(saved.getId());

        Book deleted = bookDao.getById(saved.getId());

        assertThat(deleted).isNull();
    }
}
