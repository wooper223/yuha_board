package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Board {

	@Id @GeneratedValue
	private Long id;

	private String title;

	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	public Board(String title, String content, User user) {
		this.title = title;
		this.content = content;
		this.user = user;
	}

	public Board updateBoard(String title, String content) {
		this.title = title;
		this.content = content;

		return this;
	}
}
