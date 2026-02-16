package com.example.eventmanagement.authorization1.converter;

import org.springframework.stereotype.Component;

import com.example.eventmanagement.authorization1.model.User;
import com.example.eventmanagement.authorization1.vo.UserVO;

@Component
public class UserConverter {

    public User toEntity(UserVO vo) {
        User user = new User();
        user.setEmail(vo.getEmail());
        user.setName(vo.getName());
        user.setLocation(vo.getLocation());
        user.setPassword(vo.getPassword());
        return user;
    }
}
