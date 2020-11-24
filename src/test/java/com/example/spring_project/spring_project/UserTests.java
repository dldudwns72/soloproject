package com.example.spring_project.spring_project;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.spring_project.spring_project.model.UserModelTest;
import com.example.spring_project.spring_project.repository.UserRepositoryTest;

//@DataJpaTest
public class UserTests {
	
	@Autowired
	private UserRepositoryTest userRepositorytest;
	
//	@Test
//	public void testCreateUser() {
//		UserModelTest userModel = new UserModelTest(10L,"SON","01054915786");
//		userRepositorytest.save(userModel);
//	}
//	
	@Test
	public void testGetUser(){
		System.out.println("Running test GetUser");
		Long id = 1L;
		
		Optional<UserModelTest> userModel = userRepositorytest.findById(id);
		
		Assertions.assertEquals("lee", userModel);
	}
	
	@Test
	public void testAddFail() {
		int sum = 40 + 15;
		
		// assertEquals는 두번째 파라미터의 값과 첫번째 파라미터의 값이 같아야지 테스트 통과
		// assertNotEquals는 값이 같지 않아야 테스트 통과
		Assertions.assertEquals(555, sum);
	
	}
}
