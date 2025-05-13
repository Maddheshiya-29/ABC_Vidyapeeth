package com.abcvidyapeeth.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcvidyapeeth.backend.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Optional<User> findByDeletedAndUserName(boolean deleted, String userName);
}
