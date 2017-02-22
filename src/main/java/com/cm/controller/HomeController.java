package com.cm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cm.constants.URLConstants;

@RestController
@RequestMapping()
public class HomeController {

	@RequestMapping(value = URLConstants.HOME_URL, method = RequestMethod.GET)
	public String home() {
		return "Welcome to Home page";
	}
}
