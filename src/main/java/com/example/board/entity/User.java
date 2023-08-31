package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class User {

	@Id @GeneratedValue
	private Long id;

	private String name;

	public User(String name) {
		this.name = name;
	}
}
