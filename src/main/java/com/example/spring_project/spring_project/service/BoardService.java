package com.example.spring_project.spring_project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_project.spring_project.model.BoardModel;
import com.example.spring_project.spring_project.repository.BoardRepository;
import com.example.spring_project.spring_project.service.impl.BoardServiceImpl;

@Service
public class BoardService implements BoardServiceImpl{
	
	
	private static Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@Autowired
	BoardRepository boardRepository;
	
	
	public List<BoardModel> getBoards() {
		return boardRepository.findAll();
	}

	@Override
	public BoardModel getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardModel createBoard(BoardModel boardModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyBoard() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
