package com.itech.bookstore.service;

import com.itech.bookstore.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User addUser(String userName, String permissions);

    boolean hasPermissions(String userName, String... permissions);
}
