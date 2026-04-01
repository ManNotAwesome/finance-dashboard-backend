package com.example.finance.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finance.dto.DashboardSummaryDto;
import com.example.finance.service.FinancialRecordService;

@RestController
@RequestMapping("/dashboard")

public class DashboardController {

	@Autowired
	private FinancialRecordService financialRecordService;

	@GetMapping("/summary")
	public DashboardSummaryDto getSummary() {
		return financialRecordService.getSummary();
	}

	@GetMapping("/category-summary")
	public Map<String, Double> getCategorySummary() {
		return financialRecordService.getCategorySummary();
	}
}