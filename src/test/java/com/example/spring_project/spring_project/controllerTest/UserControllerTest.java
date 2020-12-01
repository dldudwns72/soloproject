package com.example.spring_project.spring_project.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.example.spring_project.spring_project.controller.UserController;
import com.example.spring_project.spring_project.model.UserModel;
import com.example.spring_project.spring_project.repository.UserRepository;
import com.example.spring_project.spring_project.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.el.stream.Optional;

public class UserControllerTest extends AbstractControllerTest {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserController userController;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserRepository userRepository;

	@Override
	protected Object controller() {
		return userController;
	}

	@Test
	@DisplayName("User List 가져오기")
	public void getUsers() throws Exception {
		mockMvc.perform(get("/getusers")).andDo(print());
	}

	@Test
	@DisplayName("User 정보 가져오기")
	public void getUser() throws Exception {
		mockMvc.perform(get("/getuser", 1L));
	}

	@Test
	@DisplayName("User 생성")
	public void createUser() throws Exception {
		// {"id":null,"name":"kkk","phoneNumber":"2323"}
		String content = objectMapper.writeValueAsString(new UserModel("kkk2", "23223"));
		logger.info("content 내용 " + content);

		mockMvc.perform(post("/createuser").content(content).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	@DisplayName("User 수정")
	public void modifyUser() throws Exception {
//		String content = objectMapper.writeValueAsString(userRepository.findById(10L));
		String content = objectMapper.writeValueAsString(new UserModel(10L));
		
		mockMvc.perform(put("/modifyuser")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
	}

	@Test
	@DisplayName("User 삭제")
	public void deleteUser() throws Exception {
		
		String content = objectMapper.writeValueAsString(userRepository.findById(5L));
		
		mockMvc.perform(delete("/deleteuser")
					.content(content)
					.contentType(MediaType.APPLICATION_JSON)
    				.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
	}

	// 참고 https://gofnrk.tistory.com/74 , https://shinsunyoung.tistory.com/52

}
