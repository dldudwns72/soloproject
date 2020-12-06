package com.example.spring_project.spring_project.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_project.spring_project.model.BoardModel;
import com.example.spring_project.spring_project.service.BoardService;

@RestController
public class BoardController {
	
	private static Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/getboards")
	public List<BoardModel> getBoards(){
		return boardService.getBoards();
	}
	
	@GetMapping("/getboard/{no}")
	public Optional<BoardModel> getBoard(@PathVariable(name = "no") int  no) {
		return boardService.getBoard(no);
	}
	
	@PostMapping("/createboard")
	public String createBoard(@RequestBody BoardModel boardModel) {
		return boardService.createBoard(boardModel);
	}
	
	@PutMapping("/modifyboard")
	public BoardModel modifyBoard(@RequestBody BoardModel boardModel) {
		return boardService.modifyBoard(boardModel);
	}
	
	
}
