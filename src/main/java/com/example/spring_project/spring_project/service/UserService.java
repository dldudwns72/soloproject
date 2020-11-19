package com.example.spring_project.spring_project.service;

import java.util.List;
import java.util.Optional;

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
	
	public UserModel modifyUser(UserModel userModel) {
		Optional<UserModel> user = userRepository.findById(2L);
		
		user.ifPresent(selectUser ->{
			selectUser.setName("JUN");
			selectUser.setPhoneNumber("01012345678");
			
		});
		
		return userRepository.save(userModel);
	}
	
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
	    System.out.println("확인해보기:"+id);
		return "삭제되었습니다";
	}
	
}
