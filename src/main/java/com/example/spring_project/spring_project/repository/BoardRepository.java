package com.example.spring_project.spring_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_project.spring_project.model.BoardModel;

@Repository
public interface BoardRepository extends JpaRepository<BoardModel, Integer>{
//	List<BoardModel> findByName(String name); 이것처럼 없는 컬럼에 대한 DB쿼리문이 있으면 실행할 수 없다 findBy"Name"

	List<BoardModel> findAll();
	
	List<BoardModel> findByRegister(String register);
}
