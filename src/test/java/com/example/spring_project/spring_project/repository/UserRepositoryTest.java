package com.example.spring_project.spring_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_project.spring_project.model.UserModelTest;

@Repository
public interface UserRepositoryTest extends JpaRepository<UserModelTest,Long>{
	List<UserModelTest> findByName(String name);
}
