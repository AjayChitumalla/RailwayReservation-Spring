package com.org.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String processRegistration( @ModelAttribute("user") User user, HttpServletRequest request) {
		
		userRepository.save(user);
		request.setAttribute("info", "Registered successfully,Please Login !!!");
		return "login-page";
	}
}
