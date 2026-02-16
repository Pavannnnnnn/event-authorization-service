package com.example.eventmanagement.authorization1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventmanagement.authorization1.service.AuthService;
import com.example.eventmanagement.authorization1.vo.LoginRequestVO;
import com.example.eventmanagement.authorization1.vo.LoginResponseVO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseVO> login(@RequestBody LoginRequestVO request) {
		return ResponseEntity.ok(authService.login(request));
	}
	
	@PostMapping("/forgot-password")
	public ResponseEntity<String> forgotPassword(
	        @RequestParam String email,
	        @RequestParam String newPassword) {

	    authService.resetPassword(email, newPassword);
	    return ResponseEntity.ok("Password updated successfully");
	}

}
