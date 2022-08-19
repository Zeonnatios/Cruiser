package com.cruiser.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {
	
	@GetMapping(value = "/report/daily")
	public String getReportDailyPage(Model model) {
		return "report/daily_report";
	}
	
	@GetMapping(value = "/report/monthly")
	public String getReportMonthlyPage() {
		return "report/monthly_report";
	}

}
