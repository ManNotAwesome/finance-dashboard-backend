package com.example.finance.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finance.dto.DashboardSummaryDto;
import com.example.finance.dto.FinancialRecordDto;
import com.example.finance.entity.FinancialRecord;
import com.example.finance.entity.User;
import com.example.finance.exception.ResourceNotFoundException;
import com.example.finance.repository.FinancialRecordRepository;
import com.example.finance.repository.UserRepository;

@Service
public class FinancialRecordService {

	@Autowired
	private FinancialRecordRepository financialRecordRepository;

	@Autowired
	private UserRepository userRepository;

	public FinancialRecord updateRecord(Long id, FinancialRecordDto dto) {

		FinancialRecord record = financialRecordRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found"));
		record.setAmount(dto.getAmount());
		record.setType(dto.getType());
		record.setCategory(dto.getCategory());
		record.setDate(dto.getDate());
		record.setNotes(dto.getNotes());

		return financialRecordRepository.save(record);
	}

	public List<FinancialRecord> getAllRecords() {
		return financialRecordRepository.findAll();
	}

	public FinancialRecord createRecord(FinancialRecordDto dto) {

		User user = userRepository.findById(dto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		FinancialRecord record = new FinancialRecord();

		record.setAmount(dto.getAmount());
		record.setType(dto.getType());
		record.setCategory(dto.getCategory());
		record.setDate(dto.getDate());
		record.setNotes(dto.getNotes());
		record.setCreatedBy(user);

		return financialRecordRepository.save(record);
	}

	public void deleteRecord(Long id) {
		financialRecordRepository.deleteById(id);
	}

	public DashboardSummaryDto getSummary() {

		List<FinancialRecord> records = financialRecordRepository.findAll();

		Double income = 0.0;
		Double expense = 0.0;

		for (FinancialRecord record : records) {

			if (record.getType().equalsIgnoreCase("income")) {
				income += record.getAmount();
			}

			if (record.getType().equalsIgnoreCase("expense")) {
				expense += record.getAmount();
			}
		}

		Double balance = income - expense;

		return new DashboardSummaryDto(income, expense, balance);
	}

	public List<FinancialRecord> getRecordsByType(String type) {
		return financialRecordRepository.findByType(type);
	}

	public List<FinancialRecord> getRecordsByCategory(String category) {
		return financialRecordRepository.findByCategory(category);
	}

	public Map<String, Double> getCategorySummary() {

		List<FinancialRecord> records = financialRecordRepository.findAll();

		Map<String, Double> summary = new HashMap<>();

		for (FinancialRecord record : records) {

			String category = record.getCategory();

			summary.put(category, summary.getOrDefault(category, 0.0) + record.getAmount());
		}

		return summary;
	}

}
