package com.github.othaviooth.usercrud.controller;

import com.github.othaviooth.usercrud.controller.dto.UserMapper;
import com.github.othaviooth.usercrud.controller.dto.UserReponse;
import com.github.othaviooth.usercrud.controller.dto.UserRequired;
import com.github.othaviooth.usercrud.model.User;
import com.github.othaviooth.usercrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserReponse> createUser(UserRequired userRequired){
        User user = userService.createUser(UserMapper.fromDTO(userRequired));
        return ResponseEntity.ok(UserMapper.fromEntity(user));
    }

}
