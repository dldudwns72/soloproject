package com.example.spring_project.spring_project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
// class이름고 DB Table이름이 같으면 뒤에 name 선언하지 않아도 됨
@Table(name="user") 
@AllArgsConstructor
@Entity
public class UserModelTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	
	
}
