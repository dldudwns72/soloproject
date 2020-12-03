package com.example.spring_project.spring_project.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "board")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column
	private String register;
	
	@Column
	private LocalDateTime createTime;
	
	
}
