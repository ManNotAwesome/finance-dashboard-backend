package com.example.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finance.dto.FinancialRecordDto;
import com.example.finance.entity.FinancialRecord;
import com.example.finance.security.RoleChecker;
import com.example.finance.service.FinancialRecordService;

@RestController
@RequestMapping("/records")

public class FinancialRecordController {

	@Autowired
	private FinancialRecordService financialRecordService;

	@PostMapping
	public FinancialRecord createRecord(@RequestHeader("ROLE") String role, @RequestBody FinancialRecordDto dto) {

		RoleChecker.checkAdmin(role);

		return financialRecordService.createRecord(dto);
	}

	@GetMapping
	public List<FinancialRecord> getAllRecords() {
		return financialRecordService.getAllRecords();
	}

	@PutMapping("/{id}")
	public FinancialRecord updateRecord(@RequestHeader("ROLE") String role, @PathVariable Long id,
			@RequestBody FinancialRecordDto dto) {

		RoleChecker.checkAdmin(role);

		return financialRecordService.updateRecord(id, dto);
	}

	@DeleteMapping("/{id}")
	public String deleteRecord(@RequestHeader("ROLE") String role, @PathVariable Long id) {

		RoleChecker.checkAdmin(role);

		financialRecordService.deleteRecord(id);

		return "Deleted successfully";
	}

	@GetMapping("/filter/type")
	public List<FinancialRecord> getByType(@RequestParam String type) {
		return financialRecordService.getRecordsByType(type);
	}

	@GetMapping("/filter/category")
	public List<FinancialRecord> getByCategory(@RequestParam String category) {
		return financialRecordService.getRecordsByCategory(category);
	}
}