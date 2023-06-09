package com.github.othaviooth.usercrud.controller;

import com.github.othaviooth.usercrud.controller.dto.UserMapper;
import com.github.othaviooth.usercrud.controller.dto.UserReponse;
import com.github.othaviooth.usercrud.controller.dto.UserRequired;
import com.github.othaviooth.usercrud.model.User;
import com.github.othaviooth.usercrud.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserReponse> createUser(@RequestBody @Valid UserRequired userRequired){
        User user = userService.createUser(UserMapper.fromDTO(userRequired));
        return ResponseEntity.ok(UserMapper.fromEntity(user));
    }

    @GetMapping
    public ResponseEntity<List<UserReponse>> getAllUsers(){
        List<User> users = userService.gelAllUsers();
        List<UserReponse> usersDTO= users.stream().
                map(UserMapper::fromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserReponse> getUserById(@PathVariable Long id){
        User user = userService.findUserById(id);
        return ResponseEntity.ok(UserMapper.fromEntity(user));
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserReponse>> getUserByFilter(@RequestParam(value = "name", required = false) String name){
        List<User> users = userService.findUserByName(name);
        return ResponseEntity.ok(users.stream().map(UserMapper::fromEntity).collect(Collectors.toList()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}

