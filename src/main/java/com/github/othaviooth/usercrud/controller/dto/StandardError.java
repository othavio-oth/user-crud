package com.github.othaviooth.usercrud.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StandardError {

    private  LocalDateTime timestamp;
    private Integer status;
    private String message;
    private String path;
}
