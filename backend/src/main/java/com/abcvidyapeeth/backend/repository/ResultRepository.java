package com.abcvidyapeeth.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcvidyapeeth.backend.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
