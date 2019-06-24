package com.invicta.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invicta.lms.entity.User;
import java.lang.Long;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findUserById(Long id);
	
}
