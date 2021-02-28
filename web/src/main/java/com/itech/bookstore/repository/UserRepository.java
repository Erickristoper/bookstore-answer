package com.itech.bookstore.repository;

import com.itech.bookstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select usr from User usr where usr.name = :userName")
    User findByName(String userName);
}
