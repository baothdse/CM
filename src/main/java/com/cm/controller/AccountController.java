package com.cm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
    public String listAllUsers() {
        return "aaaa";
    }
}
