package com.itech.bookstore.controller;

import com.itech.bookstore.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @GetMapping(value = "/hi")
    public String sayHi() {
        return hiService.sayHi();
    }
}

