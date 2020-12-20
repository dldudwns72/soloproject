package com.example.spring_project.spring_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_project.spring_project.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
	UserModel findByName(String name);
}
