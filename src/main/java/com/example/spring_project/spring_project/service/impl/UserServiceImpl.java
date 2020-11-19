package com.example.spring_project.spring_project.service.impl;

import java.util.List;


import com.example.spring_project.spring_project.model.UserModel;

public interface UserServiceImpl {
	public List<UserModel> getUser();
	
	public UserModel createUser(UserModel userModel);
	
	public UserModel modifyUser(UserModel userModel);
	
	public String deleteUser(Long id);

}
