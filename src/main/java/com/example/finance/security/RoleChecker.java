package com.example.finance.security;

public class RoleChecker {

	public static void checkAdmin(String role) {

		if (!"ADMIN".equalsIgnoreCase(role)) {
			throw new RuntimeException("Access denied");
		}
	}
}