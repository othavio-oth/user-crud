package com.github.othaviooth.usercrud.controller.dto;


import com.github.othaviooth.usercrud.model.User;

public class UserMapper {

    public static User fromDTO(UserRequired userRequired){
        return new User(null, userRequired.getName(), userRequired.getEmail(), userRequired.getAge(), userRequired.getPassword(), userRequired.getDescription());
    }


    public static UserReponse fromEntity(User user){
        return new UserReponse(user.getId(), user.getName(), user.getEmail(), user.getAge(), user.getPassword(), user.getDescription());
    }
}
