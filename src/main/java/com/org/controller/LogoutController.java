package com.org.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public String logoutUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("id"));
		session.removeAttribute("id");
		session.invalidate();
		return "login-page";
	}
}
