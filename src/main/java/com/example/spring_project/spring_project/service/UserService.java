package com.example.spring_project.spring_project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_project.spring_project.model.UserModel;
import com.example.spring_project.spring_project.repository.BoardRepository;
import com.example.spring_project.spring_project.repository.UserRepository;
import com.example.spring_project.spring_project.service.impl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BoardRepository boardRepository;
	

	public List<UserModel> getUsers() {
		logger.info("UserModel" + userRepository.findAll());
		
		return userRepository.findAll();
	}

	@Override
	public Optional<UserModel> getUser(int userId) {

		return userRepository.findById((long)userId);
	}

	public UserModel createUser(UserModel userModel) {
		
		return userRepository.save(userModel);

	}

	public void modifyUser(Long id) {
		Optional<UserModel> user = userRepository.findById(4L);

		logger.info("ModifyUser " + userRepository.findById(4L));
		user.ifPresent(selectUser -> {
			selectUser.setName("JUN");
			selectUser.setPhoneNumber("01012345678");

			userRepository.save(selectUser);
		});

	}

	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		System.out.println("확인해보기:" + id);
		return "삭제되었습니다";
	}

}
