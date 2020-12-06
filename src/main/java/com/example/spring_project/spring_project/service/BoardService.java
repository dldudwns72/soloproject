package com.example.spring_project.spring_project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_project.spring_project.model.BoardModel;
import com.example.spring_project.spring_project.repository.BoardRepository;
import com.example.spring_project.spring_project.service.impl.BoardServiceImpl;
import java.util.Optional;

@Service
public class BoardService implements BoardServiceImpl {

	private static Logger logger = LoggerFactory.getLogger(BoardService.class);

	@Autowired
	BoardRepository boardRepository;

	public List<BoardModel> getBoards() {
		return boardRepository.findAll();
	}

	@Override
	public Optional<BoardModel> getBoard(int no) {
		return boardRepository.findById(no);
//		return boardRepository.getOne(no);
	}

	@Override
	public String createBoard(BoardModel boardModel) {
		BoardModel board = new BoardModel();
		board.setNo(boardModel.getNo());
		board.setTitle(boardModel.getTitle());
		board.setContent(boardModel.getContent());
		board.setCreateTime(boardModel.getCreateTime());
		board.setRegister(boardModel.getRegister());

		boardRepository.save(board);
		return boardModel.getTitle();
	}
	
	@Override
	public BoardModel modifyBoard(BoardModel boardModel) {
		
		BoardModel board = boardRepository.getOne(1);
		
		logger.info("ID를 가져온 BoardModel " + board);
		
		board.setNo(boardModel.getNo());
		board.setTitle(boardModel.getTitle());
		board.setContent(boardModel.getContent());
		board.setRegister(boardModel.getRegister());
		board.setCreateTime(boardModel.getCreateTime());
		
		boardRepository.save(board);
		
		return boardModel;
		
	}

}
