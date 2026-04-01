package com.example.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finance.dto.UserRequestDto;
import com.example.finance.entity.User;
import com.example.finance.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(UserRequestDto dto) {

		User user = new User();

		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setRole(dto.getRole());
		user.setActive(dto.getActive());

		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User updateUserStatus(Long id, Boolean active) {

		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		user.setActive(active);

		return userRepository.save(user);
	}
}
