package com.cruiser.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping(value = "/product/register")
	public String getProductRegisterPage(Model model) {
		
		model.addAttribute("product_action", "edit");
		return "product/product_register";
	}
	
	@GetMapping(value = "/product/list")
	public String getProductListPage() {
		return "product/product_list";
	}
}
