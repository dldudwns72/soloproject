package com.example.spring_project.spring_project.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board")
@ToString(exclude = {"user"})
public class BoardModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNo;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column
	private String register;
	
	@Column
	private String modifier;
	
	@Column(name = "create_time")
	private LocalDateTime createTime;
	
	@Column(name="modify_time")
	private LocalDateTime modifyTime;
	
	
	public BoardModel(int boardNo,String title,String content, String modifier, LocalDateTime modifyTime) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.modifier = modifier;
		this.modifyTime = modifyTime;
	}
	
	public BoardModel(String title,String content,String register,LocalDateTime createTime,UserModel user) {
		this.title = title;
		this.content= content;
		this.register = register;
		this.createTime = createTime;
		this.user = user;
	}

	
	// N : 1
	@ManyToOne(optional = true, fetch = FetchType.LAZY) // optional 기본값 true 일때 userId가 없어도 조회가 되야하므로 Outer Join, false일 경우 반대
	@JoinColumn(name = "userId")
	private UserModel user; //디비 칼럼에 user_id로 들어감, 실제로는 변수명의_id 형태로 들어가는 것이다, MUL로 들어가는이유?
	
}
