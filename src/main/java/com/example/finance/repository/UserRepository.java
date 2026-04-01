package com.example.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finance.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
