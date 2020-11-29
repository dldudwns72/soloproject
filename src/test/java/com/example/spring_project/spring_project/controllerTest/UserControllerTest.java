package com.example.spring_project.spring_project.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.spring_project.spring_project.controller.UserController;

public class UserControllerTest extends AbstractControllerTest{
	
	@Autowired
	private UserController userController;
	
	@Override
	protected Object controller() {
		return userController;
	}
	
	@Test
	@DisplayName("User List 가져오기")
	public void getUsers() throws Exception{
		mockMvc.perform(get("/getusers"));
	}
	
	@Test
	@DisplayName("User 정보 가져오기")
	public void getUser() throws Exception{
		mockMvc.perform(get("/getuser",1L));
	}
	
	@Test
	@DisplayName("User 생성")
	public void createUser() throws Exception{
		mockMvc.perform(post("/createuser")
				.param("name", "Joe")
				.param("phoneNumber", "123456789")				
				);
	}
	
	// 참고 https://gofnrk.tistory.com/74

}
