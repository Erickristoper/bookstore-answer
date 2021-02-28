package com.itech.bookstore.service;

import org.springframework.stereotype.Service;

@Service
public class HiServiceImpl implements HiService {

    public String sayHi() {
        return "Hi, Candidate!";
    }

}
