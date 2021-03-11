package com.itech.bookstore.repository;

import com.itech.bookstore.domain.Book;
import com.itech.bookstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b from Book b where b.name = :bookName")
    List<Book> findByName(String bookName);
}
