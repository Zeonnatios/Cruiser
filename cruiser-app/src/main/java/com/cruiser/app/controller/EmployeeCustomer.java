package com.cruiser.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeCustomer {

	@GetMapping(value = "/employee/register")
	public String getEmployeeRegisterPage(Model model) {
		
		model.addAttribute("employee_action", "create");
		return "employee/employee_register";
	}
	
	@GetMapping(value = "/employee/list")
	public String getEmployeeListPage() {
		return "employee/employee_list";
	}

}
