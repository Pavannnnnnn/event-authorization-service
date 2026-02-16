package com.example.eventmanagement.authorization1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventmanagement.authorization1.model.User;
import com.example.eventmanagement.authorization1.service.UserService;
import com.example.eventmanagement.authorization1.vo.UpdateUserRequest;
import com.example.eventmanagement.authorization1.vo.UserVO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody UserVO userVO) {
		userService.createUser(userVO);
		return ResponseEntity.ok("User created successfully");
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<Integer> getUserIdByEmail(@PathVariable(name = "email") String email) {
		User user = userService.getByEmail(email);
		return ResponseEntity.ok(user.getUserId());
	}
	
	@PutMapping("/update/{email}")
	public ResponseEntity<String> updateUser(
	        @PathVariable String email,
	        @RequestBody UpdateUserRequest request) {

	    userService.updateUser(email, request);
	    return ResponseEntity.ok("Profile updated successfully");
	}


}
