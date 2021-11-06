package com.sfg.sdjpa.jdbc;

import com.sfg.sdjpa.jdbc.dao.AuthorDao;
import com.sfg.sdjpa.jdbc.domain.Author;
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
public class AuthorDaoIntegrationTest {

    @Autowired
    AuthorDao authorDao;

    @Test
    void testGetAuthor() {
        Author author = authorDao.getById(1L);

        assertThat(author).isNotNull();
    }

    @Test
    void shouldGetAuthorByName() {
        Author author = authorDao.getByName("Craig");

        assertThat(author.getFirstName()).isEqualTo("Craig");
        assertThat(author.getLastName()).isEqualTo("Walls");

        author = authorDao.getByName("Martin");

        assertThat(author.getFirstName()).isEqualTo("Robert");
    }
}
