package com.example.spring_project.spring_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring_project.spring_project.model.UserModel;
import com.example.spring_project.spring_project.repository.UserRepository;
import com.example.spring_project.spring_project.service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl {
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserModel> getUser(){
		return userRepository.findAll();
	}
	
	public UserModel createUser(UserModel userModel) {
		return userRepository.save(userModel);
	}
}
