package com.example.spring_project.spring_project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_project.spring_project.model.BoardModel;
import com.example.spring_project.spring_project.model.UserModel;
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
//		BoardModel boardModel = boardRepository.findById(no).orElse(null);
		
		return boardRepository.findById(no);
//		return boardRepository.getOne(no);
	}

	@Override
	public String createBoard(BoardModel boardModel) {
		BoardModel board = new BoardModel();
		board.setBoardNo(boardModel.getBoardNo());
		board.setTitle(boardModel.getTitle());
		board.setContent(boardModel.getContent());
		board.setCreateTime(boardModel.getCreateTime());
		board.setRegister(boardModel.getRegister());
		board.setUser(boardModel.getUser());
		
		boardRepository.save(board);
		return boardModel.getTitle();
	}
	
	@Override
	public BoardModel modifyBoard(BoardModel boardModel) {
		
		Optional<BoardModel> board = boardRepository.findById(boardModel.getBoardNo());
		
		logger.info("ID를 가져온 BoardModel " + board);
		board.ifPresent(data ->{
			data.setBoardNo(boardModel.getBoardNo());
			data.setTitle(boardModel.getTitle());
			data.setContent(boardModel.getContent());
			data.setModifier(boardModel.getModifier());
			data.setModifyTime(LocalDateTime.now());

			boardRepository.save(data);
		
			
		});
		
		return boardModel;
		
	}
	
	@Override
	public String deleteBoard(int no) {
		boardRepository.deleteById(no);
		return "삭제 완료하였습니다";
	}

}
