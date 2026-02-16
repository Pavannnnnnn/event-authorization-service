package com.example.eventmanagement.authorization1.service;

import com.example.eventmanagement.authorization1.model.User;
import com.example.eventmanagement.authorization1.vo.UpdateUserRequest;
import com.example.eventmanagement.authorization1.vo.UserVO;

public interface UserService {
    public void createUser(UserVO userVO);
    
    public User getByEmail(String email);
    
    public void updateUser(String email, UpdateUserRequest request);

}

