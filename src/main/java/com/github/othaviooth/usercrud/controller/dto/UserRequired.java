package com.github.othaviooth.usercrud.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequired {

    @NotBlank(message = "{name.not.blank}")
    private String name;
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    //@NotNull(message = "{age.not.null}")
    @NotNull(message = "{age.not.null}")
    private Integer age;

    @NotBlank(message = "{password.not.blank}")
    private String password;
    private String description;
}
