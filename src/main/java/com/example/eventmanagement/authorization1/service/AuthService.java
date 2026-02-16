package com.example.eventmanagement.authorization1.service;

import com.example.eventmanagement.authorization1.vo.LoginRequestVO;
import com.example.eventmanagement.authorization1.vo.LoginResponseVO;

public interface AuthService {
    LoginResponseVO login(LoginRequestVO request);
    
    void resetPassword(String email, String newPassword);

}
