package com.example.spring_project.spring_project;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.spring_project.spring_project.model.UserModelTest;
import com.example.spring_project.spring_project.repository.UserRepositoryTest;

@DataJpaTest
public class UserTests {
	
	@Autowired
	private UserRepositoryTest userRepositorytest;
	
	@Test
	public void testCreateUser() {
		UserModelTest userModel = new UserModelTest(10L,"SON","01054915786");
		userRepositorytest.save(userModel);
	}
	
	@Test
	public List<UserModelTest> testGetUser(){
		return userRepositorytest.findAll();
	}
}
