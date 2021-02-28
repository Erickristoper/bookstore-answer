package com.itech.bookstore.service;

import com.itech.bookstore.domain.User;
import com.itech.bookstore.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(String userName, String permissions) {
        User u = new User(userName, permissions);
        logger.debug("Adding User {}", u);
        return userRepository.save(u);
    }

    public boolean hasPermissions(String userName, String... permissions) {
        String userPerms = userRepository.findByName(userName).getPermissions();
        boolean hasAllPerm = true;
        for (String permission : permissions) {
            hasAllPerm = hasAllPerm && userPerms.contains(permission);
        }
        return hasAllPerm;
    }
}
