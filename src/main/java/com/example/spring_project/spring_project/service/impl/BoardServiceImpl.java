package com.example.spring_project.spring_project.service.impl;

import java.util.List;
import com.example.spring_project.spring_project.model.BoardModel;

public interface BoardServiceImpl {
	public List<BoardModel> getBoards();
	
	public BoardModel getBoard();
	
	public BoardModel createBoard(BoardModel boardModel);
	
	public String deleteBoard();
	
	public String modifyBoard();
	
	
}
