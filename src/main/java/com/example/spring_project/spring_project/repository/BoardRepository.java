package com.example.spring_project.spring_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_project.spring_project.model.BoardModel;

@Repository
public interface BoardRepository extends JpaRepository<BoardModel, Integer>{
	List<BoardModel> findByName(String name);

	List<BoardModel> findAll();
}
