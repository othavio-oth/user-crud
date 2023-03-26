package com.github.othaviooth.usercrud.repository;

import com.github.othaviooth.usercrud.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByNameIgnoreCase(String name);

}
