package com.example.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.Service.BoardService;
import com.example.board.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardController {

	private final BoardService boardService;

	@PostMapping("/create")
	public ResponseEntity<Long> createBoard(BoardDto boardDto) {
		Long boardId = boardService.createBoard(boardDto);
		return new ResponseEntity(boardId, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BoardDto> getBoard(@PathVariable Long id) {
		BoardDto board = boardService.getBoard(id);
		return new ResponseEntity<>(board, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteBoard(@PathVariable Long id) {
		boardService.deleteBoard(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public ResponseEntity updateBoard(BoardDto boardDto) {
		boardService.updateBoard(boardDto);
		return new ResponseEntity(HttpStatus.OK);
	}

}
