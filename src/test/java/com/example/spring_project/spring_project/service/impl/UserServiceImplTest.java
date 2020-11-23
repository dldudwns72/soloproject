package com.example.spring_project.spring_project.service.impl;

import java.util.List;

import com.example.spring_project.spring_project.model.UserModelTest;



public interface UserServiceImplTest {
	public List<UserModelTest> getUser();
	
	public UserModelTest createUser(UserModelTest userModel);
	
	public void modifyUser(Long id);
	
	public String deleteUser(Long id);

}
