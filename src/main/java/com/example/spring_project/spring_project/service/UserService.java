package com.example.spring_project.spring_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_project.spring_project.model.UserModel;
import com.example.spring_project.spring_project.repository.UserRepository;
import com.example.spring_project.spring_project.service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl{
	
	@Autowired
	UserRepository userRepository;
	
	
	
	public List<UserModel> getUser(){
		System.out.println("userRepository.findAll()" + userRepository.findAll());
		return userRepository.findAll();
	}
	
	public UserModel createUser(UserModel userModel) {
		return userRepository.save(userModel);
	}
	
	public void modifyUser(Long id) {
		Optional<UserModel> user = userRepository.findById(4L);
			
		
		user.ifPresent(selectUser ->{
			selectUser.setName("JUN");
			selectUser.setPhoneNumber("01012345678");

			 userRepository.save(selectUser);
		});
		
	}
	
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
	    System.out.println("확인해보기:"+id);
		return "삭제되었습니다";
	}
	
}
