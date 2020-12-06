package com.example.spring_project.spring_project.service.impl;

import java.util.List;
import com.example.spring_project.spring_project.model.BoardModel;
import java.util.Optional;

public interface BoardServiceImpl {
	public List<BoardModel> getBoards();
	
	public Optional<BoardModel> getBoard(int no);
	
	public String createBoard(BoardModel boardModel);
	
	
//	public String deleteBoard();
//	
	public BoardModel modifyBoard(BoardModel boardModel);
//	
	
}
