package com.github.othaviooth.usercrud.controller;

import com.github.othaviooth.usercrud.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.othaviooth.usercrud.controller.dto.LoginDTO;
import com.github.othaviooth.usercrud.model.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("login")
    public String login(@RequestBody LoginDTO loginDto){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

        var user =(User) authentication.getPrincipal();

        return tokenService.generateToken(user);
    }
    
}
