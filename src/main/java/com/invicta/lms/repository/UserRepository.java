package com.invicta.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invicta.lms.entity.User;
import java.lang.Long;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findUserById(Long id);
	
}
