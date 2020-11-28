package com.example.spring_project.spring_project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_project.spring_project.controller.UserController;
import com.example.spring_project.spring_project.model.UserModel;
import com.example.spring_project.spring_project.repository.UserRepository;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Propagation;


// 실제 디비를 가지고 테스트 할 경우 설정해줘야하는 라이브러리
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
//@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserTests {

	// mock을 통한 현재 데이터베이스를 참조하지 않고 jpa 테스트를 해보기

	@Autowired
	private UserRepository userRepository;
	
	private MockMvc mockMvc;
	
//	@Autowired
//	private UserController userController;
	
//	 Junit5에서 테스트 메소드 실행 전 셋업 메소드 (Junit4에서는 @Before으로 사용)( 
	@BeforeEach
	public void setup() {
		// UserController를 MockMvc 객체로 만든다
		mockMvc = MockMvcBuilders.standaloneSetup(UserController.class).build();
	}
	

	@Test
	@DisplayName("테스트 실패 junit")
	public void testAddFail() {
		int sum = 40 + 15;
		// assertEquals는 두번째 파라미터의 값과 첫번째 파라미터의 값이 같아야지 테스트 통과
		// assertNotEquals는 값이 같지 않아야 테스트 통과
		Assertions.assertEquals(55, sum);
	}
	
	@Test 
	public void testUserController() throws Exception{
			mockMvc.perform(get("/getuser"));
	}

	@Test
	@DisplayName("유저 정보 가져오기")
	void getUser() {
		List<UserModel> userModel= userRepository.findAll();
		userModel.get(0).getName();
		// 첫번째 userModelTest의 이름이 "lee" 와 같으면 테스트 통과
      // assertEquals("lee", userModelTest.get(0).getName());

		// userModelTest의 size가 2이면 통과 , 세번째 파라미터는 오류 메세지를 보여준다
		assertEquals(2, userModel.size(),"사이즈가 맞지 않다");
	}
//
//	@Test
//	void createUser() {
//		UserModelTest userModelTest = new UserModelTest(3L, "DeleteUser", "54915786");
//		userRepositorytest.save(userModelTest);
//	}
//
//	@Test
//	void modifyUser() {
//		Optional<UserModelTest> userModelTest = userRepositorytest.findById(1L);
//		userModelTest.ifPresent(user -> {
//			user.setName("kwak");
//			user.setPhoneNumber("987654321");
//			userRepositorytest.save(user);
//		});
//	}
//	
//	@Test
//	void deleteUser() {
//		userRepositorytest.deleteById(3L);
//	}
	
}
