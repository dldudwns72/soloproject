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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
// class이름고 DB Table이름이 같으면 뒤에 name 선언하지 않아도 됨
@Table(name="user") 
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column
	private LocalDateTime createDate;
	
	// 만들어질때 순서 확인해보기 -> 단순히 정할 수 없으며 따로 알고리즘을 작성하여 해야한다
	@Column
	private boolean isUser;
	
	
	public UserModel(String name,String phoneNumber,LocalDateTime createDate,boolean isUser) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.createDate = createDate;
		this.isUser = isUser;
	}
	
	public UserModel(Long id) {
		this.id = id;
	}

	
	
	
	
}
