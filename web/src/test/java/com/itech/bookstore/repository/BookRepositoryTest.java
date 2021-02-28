package com.itech.bookstore.repository;

import com.itech.bookstore.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(value = "classpath:application-test.properties")
@Sql(scripts = {"classpath:database/script.sql"})
class BookRepositoryTest {

    @Autowired
    private BookRepository booksRepository;

    @Test
    void testGetAllBooks() {
        List<Book> allBooks = booksRepository.findAll();
        assertThat(allBooks.size()).isEqualTo(4);
    }
}
