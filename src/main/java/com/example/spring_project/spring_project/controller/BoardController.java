package com.example.spring_project.spring_project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_project.spring_project.model.BoardModel;
import com.example.spring_project.spring_project.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardModel boardModel;
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/getboards")
	public List<BoardModel> getBoards(){
		return boardService.getBoards();
	}
	
}
