package com.iftm.projeto.carros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.projeto.carros.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findUserByEmail(String email);
}