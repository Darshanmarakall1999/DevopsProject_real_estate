package com.thbs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.thbs.repo.UserRepository;

@Controller
public class MainController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/")
	public String index() {
		return "register";
	}

	/*
	 * @RequestMapping(value = "/login") public String register() { return "index";
	 * }
	 * 
	 * @RequestMapping(value = "/estate_details") public String home() { return
	 * "estate_details"; }
	 */

}