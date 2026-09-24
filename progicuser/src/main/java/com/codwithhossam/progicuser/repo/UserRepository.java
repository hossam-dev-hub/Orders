package com.codwithhossam.progicuser.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codwithhossam.progicuser.enums.UserType;
import com.codwithhossam.progicuser.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
       
	 Optional<User> findByEmail(String email);
	 List<User> findByType(UserType type);
}
