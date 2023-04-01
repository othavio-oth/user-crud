package com.github.othaviooth.usercrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.othaviooth.usercrud.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByNameIgnoreCase(String name);
    User findUserByEmail(String email);

}
