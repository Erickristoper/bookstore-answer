package com.itech.bookstore.repository;

import com.itech.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b from Book b where lower(b.name) = :bookName")
    List<Book> findByName(String bookName);

    @Query(value = "select b from Book b where b.id = :id")
    List<Book> findById(int id);


}
