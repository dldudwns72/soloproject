package com.example.spring_project.spring_project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring_project.spring_project.model.UserModelTest;
import com.example.spring_project.spring_project.repository.UserRepositoryTest;

//@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringProjectApplicationTests {
	
	@Autowired
	UserRepositoryTest userRepository;
	
	@Autowired
	UserModelTest userModelTest1;
	
	@Test
	void contextLoads() {
		System.out.println("abc");
	}
	
	@Test
	void addtion() {
		assertEquals(2, 1+1);
		System.out.println("123ㄴㅇㄹ");
	}
	
	@Test
	@DisplayName("User정보 GET")
	public List<UserModelTest> getUser() {
		System.out.println("!@#!@#");
		return userRepository.findAll();
	}
	
	
//  JUnit5 라이프 사이클
//	 @BeforeAll
//	    static void beforeAll() {
//	        System.out.println("BeforeAll method call");
//	    }
//
//	    @BeforeEach
//	    void beforeEach() {
//	        System.out.println("");
//	        System.out.println("BeforeEach method call");
//	    }
//
//	    @Test
//	    void succeedingTest() {
//	        System.out.println("succeedingTest method call");
//	    }
//
//	    @Test
//	    void succeedingTest_2() {
//	        System.out.println("succeedingTest_2 method call_2");
//	    }
//
//	    @AfterEach
//	    void afterEach() {
//	        System.out.println("afterEach method call");
//	    }
//
//	    @AfterAll
//	    static void afterAll() {
//	        System.out.println("afterAll method call");
//	    }

}
