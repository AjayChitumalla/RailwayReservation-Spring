package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.org.bean.User;
import com.org.repository.UserRepository;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("user") User user) {
		
		return "registration-page";
	}
	
	@RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
	public String processRegistration( @ModelAttribute("user") User user) {
		
		userRepository.save(user);
		return "login-page";
	}
}
