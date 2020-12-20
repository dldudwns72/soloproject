package com.example.spring_project.spring_project.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Embeddable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.example.spring_project.spring_project.controller.BoardController;
import com.example.spring_project.spring_project.model.BoardModel;
import com.example.spring_project.spring_project.model.UserModel;
import com.example.spring_project.spring_project.repository.UserRepository;
import com.example.spring_project.spring_project.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BoardControllerTest extends AbstractControllerTest {

	private static Logger logger = LoggerFactory.getLogger(BoardService.class);

	@Autowired
	private BoardController boardController;
	
	@Autowired
	private UserRepository  userRepoistory;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	protected Object controller() {
		return boardController;
	}

	@Test
	@DisplayName("Board List 가져오기")
	public void getBoards() throws Exception {
		mockMvc.perform(get("/getboards")).andDo(print());
	}
	
	@Test
	@DisplayName("Board 정보")
	public void getBoard() throws Exception {
		mockMvc.perform(get("/getboard/2"));
	}

	@Test
	@DisplayName("게시판 생성")
	public void createBoards() throws Exception {
		UserModel user = userRepoistory.findByName("joo");

		BoardModel boardModel = new BoardModel("제목44", "내용44", "yjlee", LocalDateTime.now(),user);
		
		
		String content = objectMapper.writeValueAsString(boardModel);
		
		mockMvc.perform(post("/createboard").content(content).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
	}

	@Test
	@DisplayName("게시판 수정")
	public void modifyBoard() throws Exception {

		String content = objectMapper.writeValueAsString(new BoardModel(2,"수정제목", "수정내용", "yjlee수정자", LocalDateTime.now()));

		mockMvc.perform(put("/modifyboard").content(content).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	@DisplayName("ID로 게시판 삭제")
	public void deleteBoard() throws Exception {
		mockMvc.perform(delete("/deleteboard/2"));
	}

}
