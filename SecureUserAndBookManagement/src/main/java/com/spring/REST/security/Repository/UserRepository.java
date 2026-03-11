package com.spring.REST.security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.REST.security.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

}
