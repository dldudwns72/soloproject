package com.example.spring_project.spring_project.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring_project.spring_project.model.UserModelTest;
import com.example.spring_project.spring_project.repository.UserRepositoryTest;
import com.example.spring_project.spring_project.service.UserServiceTest;



@Controller
public class UserControllerTest {
	
	@Autowired
	UserRepositoryTest userRepository;
	
	@Autowired
	UserServiceTest userService;
	
	@Test
	@GetMapping("/getuser")
	public List<UserModelTest> getUser() {
		return userService.getUser();
	}
	
	@PostMapping("/createuser")
	public void create(@RequestBody UserModelTest userModel) {
		userService.createUser(userModel);
	}
	
	@PutMapping("/modifyuser")
	public void update(@RequestBody UserModelTest userModel) {
		userService.modifyUser(userModel.getId());
	}
	
	@DeleteMapping("/deleteuser")
	public void delete(@RequestBody UserModelTest userModel) {
		userService.deleteUser(userModel.getId());
	}
	
}
