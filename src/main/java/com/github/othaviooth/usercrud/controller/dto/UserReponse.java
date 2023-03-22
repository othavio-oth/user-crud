package com.github.othaviooth.usercrud.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReponse {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String password;
    private String description;
}
