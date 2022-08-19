package com.cruiser.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MallController {
	
	@GetMapping(value = "/mall/cart")
	public String getCartPage(Model model) {
		
		model.addAttribute("product_action", "edit");
		return "mall/cart";
	}
	
	@GetMapping(value = "/mall/sale-search")
	public String getSaleSearchPage() {
		return "mall/sale_search";
	}
	
	@GetMapping(value = "/mall/detailed-sale-search")
	public String getDetailedSaleSearchPage() {
		return "mall/detailed_sale_search";
	}

}
