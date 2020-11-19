package com.example.spring_project.spring_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_project.spring_project.model.UserModel;
import com.example.spring_project.spring_project.repository.UserRepository;
import com.example.spring_project.spring_project.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/getuser")
	public List<UserModel> getUser() {
		return userService.getUser();
	}
	
	@PostMapping("/createuser")
	public void create(@RequestBody UserModel userModel) {
		userService.createUser(userModel);
		
	}
	
	@PutMapping("/modifyuser")
	public void update() {
		Optional<UserModel> user = userRepository.findById(2L);
				
		user.ifPresent(selectUser ->{
			selectUser.setName("JUN");
			selectUser.setPhoneNumber("01012345678");

			userRepository.save(selectUser);
		});
	}
	
	@DeleteMapping("/deleteuser")
	public void delete() {
		userRepository.deleteById(2L);
	}
}
