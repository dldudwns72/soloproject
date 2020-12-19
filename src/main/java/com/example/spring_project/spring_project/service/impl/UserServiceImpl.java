package com.example.spring_project.spring_project.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.spring_project.spring_project.model.UserModel;


public interface UserServiceImpl {
	public List<UserModel> getUsers();
	
	public Optional<UserModel> getUser(int userId);
	
	public UserModel createUser(UserModel userModel);
	
	public void modifyUser(Long id);
	
	public String deleteUser(Long id);

}
