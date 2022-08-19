package com.cruiser.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {
	
	@GetMapping(value = "/store/register")
	public String getStoreRegisterPage(Model model) {
		
		model.addAttribute("store_action", "create");
		return "store/store_register";
	}
	
	@GetMapping(value = "/store/list")
	public String getStoreListPage() {
		return "store/store_list";
	}

}
