package com.github.othaviooth.usercrud.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.othaviooth.usercrud.model.User;

@Service
public class TokenService {


    public String generateToken(User user) {

        return JWT.create()
        .withIssuer("user-crud")
        .withSubject(user.getUsername())
        .withClaim("id", user.getId())
        .withExpiresAt(LocalDateTime.now().plusSeconds(90).toInstant(ZoneOffset.of("-03:00")))
        .sign(Algorithm.HMAC256("SECRET"));


    }
}
