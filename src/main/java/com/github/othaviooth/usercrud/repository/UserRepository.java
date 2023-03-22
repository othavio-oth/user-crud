package com.github.othaviooth.usercrud.repository;

import com.github.othaviooth.usercrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
