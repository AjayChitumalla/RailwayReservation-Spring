package com.org.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		
	@RequestMapping("/processLogin") 
	public String processLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request) {
		
		User user = userRepository.findByUserNameAndPassword(userName, password);
		if(user == null) {
			request.setAttribute("info", "Invalid credentials, please try again !!!");
			return "login-page";
		}
		HttpSession session = request.getSession();
		session.setAttribute("id", user.getId());
		return "home";
	}
	
	@RequestMapping("/home")
	public String showHomePage() {
		
		return "home";
	}
}
