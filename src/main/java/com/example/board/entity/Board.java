package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Board {

	@Id @GeneratedValue
	private Long id;

	private String title;

	private String content;

	private String name;

	// @ManyToOne(fetch = FetchType.LAZY)
	// private User user;

	public Board(String title, String content, String name) {
		this.title = title;
		this.content = content;
		this.name = name;
	}

	public void updateBoard(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
