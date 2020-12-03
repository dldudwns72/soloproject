package com.example.spring_project.spring_project.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.spring_project.spring_project.controller.BoardController;
import com.example.spring_project.spring_project.service.BoardService;

public class BoardControllerTest extends AbstractControllerTest {

	private static Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	private BoardController boardController;
	
	@Override
	protected Object controller() {
		return boardController;
	}
	
	@Test
	@DisplayName("Board List 가져오기")
	public void getBoards() throws Exception {
		mockMvc.perform(get("/getboards")).andDo(print());
	}
	

}
