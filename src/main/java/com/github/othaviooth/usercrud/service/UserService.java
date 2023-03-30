package com.github.othaviooth.usercrud.service;

import com.github.othaviooth.usercrud.exceptions.ObjectNotFoundException;
import com.github.othaviooth.usercrud.model.User;
import com.github.othaviooth.usercrud.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User createUser(User user){
        return this.userRepository.save(user);
    }

    public User findUserById(Long id) throws ObjectNotFoundException{
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public User findUserByEmail(String email)throws ObjectNotFoundException{
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.orElseThrow(()-> new ObjectNotFoundException("User not Found"));
    }

    public User findUserByUsername(String username)throws ObjectNotFoundException{
        Optional<User> user = userRepository.findUserByUsername(username);
        return user.orElseThrow(()-> new ObjectNotFoundException("User not Found"));
    }

    public List<User> findUserByName(String name){
       return this.userRepository.findUserByNameIgnoreCase(name);
    }

    public List<User> gelAllUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUser(Long id){
        User user = this.findUserById(id);
        userRepository.delete(user);
    }


}