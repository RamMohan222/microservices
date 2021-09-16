package com.airline.adminservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.adminservice.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
	UserEntity findByUsernameAndPassword(String username, String password);
}
