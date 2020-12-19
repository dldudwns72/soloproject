package com.example.spring_project.spring_project.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// class이름고 DB Table이름이 같으면 뒤에 name 선언하지 않아도 됨
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "name")
	private String name;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column
	private LocalDateTime createDate;

	// 만들어질때 순서 확인해보기 -> 단순히 정할 수 없으며 따로 알고리즘을 작성하여 해야한다
	@Column
	private boolean isUser;

	public UserModel(String name, String phoneNumber, LocalDateTime createDate, boolean isUser, List<BoardModel> boardModelList ) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.createDate = createDate;
		this.isUser = isUser;
		this.boardModelList = boardModelList;
	}

	public UserModel(Long userId) {
		this.userId = userId;
	}


	// 본인을 기준으로 N:M 기준 설정, 앞이 본인
	// 1:N mappedBy = "ManyToOne 에서 선언한 변수 명 "
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // mappedBy로 user과 연관이 있는 것을 알려준다.
	private List<BoardModel> boardModelList;

}
