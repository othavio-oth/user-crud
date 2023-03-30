package com.github.othaviooth.usercrud.repository;

import com.github.othaviooth.usercrud.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByNameIgnoreCase(String name);

    Optional<User> findUserByEmail(String email);

}
