package com.example.eventmanagement.authorization1.service.impl;

import org.springframework.stereotype.Service;

import com.example.eventmanagement.authorization1.model.User;
import com.example.eventmanagement.authorization1.repository.UserRepository;
import com.example.eventmanagement.authorization1.service.AuthService;
import com.example.eventmanagement.authorization1.vo.LoginRequestVO;
import com.example.eventmanagement.authorization1.vo.LoginResponseVO;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoginResponseVO login(LoginRequestVO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        LoginResponseVO response = new LoginResponseVO();
        response.setUserId(user.getUserId()); 
        response.setEmail(user.getEmail());
        response.setName(user.getName());
        response.setMessage("Login successful");
        return response;
    }
    
    @Override
    public void resetPassword(String email, String newPassword) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not found"));

        user.setPassword(newPassword);
        userRepository.save(user);
    }

}
