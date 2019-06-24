package com.invicta.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invicta.lms.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
