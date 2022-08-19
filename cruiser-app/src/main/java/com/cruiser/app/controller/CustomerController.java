package com.cruiser.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
	
	@GetMapping(value = "/customer/register")
	public String getCustomerRegisterPage(Model model) {
		
		model.addAttribute("customer_action", "create");
		
		return "customer/customer_register";
	}
	
	@GetMapping(value = "/customer/list")
	public String getCustomerListPage() {
		return "customer/customer_list";
	}

}
