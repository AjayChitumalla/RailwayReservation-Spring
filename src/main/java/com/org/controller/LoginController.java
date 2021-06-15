package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.bean.User;
import com.org.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping({"/","/login"})
	public String showLoginPage() {
		
		return "login-page";
	}
	
	@ResponseBody	
	@RequestMapping("/processLogin") 
	public String processLogin(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		
		User user = userRepository.findByUserNameAndPassword(userName, password);
		if(user == null) {
			return "not found";
		}
		return "found";
	}
}
