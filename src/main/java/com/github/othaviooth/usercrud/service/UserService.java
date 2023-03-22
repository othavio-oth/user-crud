package com.github.othaviooth.usercrud.service;

import com.github.othaviooth.usercrud.model.User;
import com.github.othaviooth.usercrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user){
        return this.userRepository.save(user);
    }

    public User findUserById(Long id){
        Optional<User> user = this.userRepository.findById(id);
        return user.orElse(null);
    }

    public List<User> gelAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        User user = this.findUserById(id);
        userRepository.delete(user);
    }


}
