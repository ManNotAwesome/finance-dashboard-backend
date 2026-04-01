package com.example.finance.dto;

public class DashboardSummaryDto {

	private Double totalIncome;
	private Double totalExpense;
	private Double netBalance;

	public DashboardSummaryDto(Double totalIncome, Double totalExpense, Double netBalance) {
		this.totalIncome = totalIncome;
		this.totalExpense = totalExpense;
		this.netBalance = netBalance;
	}

	public Double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}

	public Double getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(Double totalExpense) {
		this.totalExpense = totalExpense;
	}

	public Double getNetBalance() {
		return netBalance;
	}

	public void setNetBalance(Double netBalance) {
		this.netBalance = netBalance;
	}
}