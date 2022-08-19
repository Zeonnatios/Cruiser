package com.cruiser.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@GetMapping(value = "/login")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String postLoginPage() {
		
		return "redirect:/home";
		
	}
	
	@GetMapping(value = "home")
	public String getHomePage() {
		return "home";
	}

	@GetMapping(value = "/logout")
	public String logout() {
		
	    return "redirect:/login";
	    
	}
	
}
