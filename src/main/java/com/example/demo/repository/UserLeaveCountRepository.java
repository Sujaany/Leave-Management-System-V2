package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserLeaveCount;

public interface UserLeaveCountRepository extends JpaRepository<UserLeaveCount, Long> {

}
