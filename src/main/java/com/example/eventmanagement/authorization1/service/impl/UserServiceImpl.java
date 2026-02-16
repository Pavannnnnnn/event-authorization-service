package com.example.eventmanagement.authorization1.service.impl;

import org.springframework.stereotype.Service;

import com.example.eventmanagement.authorization1.converter.UserConverter;
import com.example.eventmanagement.authorization1.model.User;
import com.example.eventmanagement.authorization1.repository.UserRepository;
import com.example.eventmanagement.authorization1.service.UserService;
import com.example.eventmanagement.authorization1.vo.UpdateUserRequest;
import com.example.eventmanagement.authorization1.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserConverter userConverter;

	public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
		this.userRepository = userRepository;
		this.userConverter = userConverter;
	}

	@Override
	public void createUser(UserVO userVO) {
		if (userRepository.existsByEmail(userVO.getEmail())) {
			throw new RuntimeException("Email already exists");
		}
		User user = userConverter.toEntity(userVO);
		userRepository.save(user);
	}

	@Override
	public User getByEmail(String email) {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User not found"));
	}
	
	@Override
	public void updateUser(String email, UpdateUserRequest request) {

	    User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    if (request.getName() != null && !request.getName().isEmpty()) {
	        user.setName(request.getName());
	    }

	    if (request.getLocation() != null && !request.getLocation().isEmpty()) {
	        user.setLocation(request.getLocation());
	    }

	    if (request.getPassword() != null && !request.getPassword().isEmpty()) {
	        user.setPassword(request.getPassword());
	    }

	    userRepository.save(user);
	}

}
