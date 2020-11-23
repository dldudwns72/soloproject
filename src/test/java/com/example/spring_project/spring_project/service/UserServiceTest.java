package com.example.spring_project.spring_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_project.spring_project.model.UserModelTest;
import com.example.spring_project.spring_project.repository.UserRepositoryTest;
import com.example.spring_project.spring_project.service.impl.UserServiceImplTest;

@Service
public class UserServiceTest implements UserServiceImplTest {
	
	@Autowired
	UserRepositoryTest userRepository;
	
	public List<UserModelTest> getUser(){
		return userRepository.findAll();
	}
	
	public UserModelTest createUser(UserModelTest userModel) {
		userModel.setName("kkkkk");
		userModel.setPhoneNumber("12312312412412412a");
		
		return userRepository.save(userModel);
	}
	
	public void modifyUser(Long id) {
		Optional<UserModelTest> user = userRepository.findById(1L);
			
		
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
