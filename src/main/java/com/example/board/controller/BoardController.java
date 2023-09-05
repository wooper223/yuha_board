package com.example.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.Service.BoardService;
import com.example.board.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class BoardController {

	private final BoardService boardService;

	@PostMapping("/board")
	public ResponseEntity<Long> createBoard(@RequestBody BoardDto boardDto) {
		Long boardId = boardService.create(boardDto);
		return new ResponseEntity<>(boardId, HttpStatus.OK);
	}

	@GetMapping("/board/{id}")
	public ResponseEntity<BoardDto> getBoard(@PathVariable Long id) {
		BoardDto board = boardService.getOne(id);
		return new ResponseEntity<>(board, HttpStatus.OK);
	}

	@DeleteMapping("/board/{id}")
	public ResponseEntity deleteBoard(@PathVariable Long id) {
		boardService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/board")
	public ResponseEntity updateBoard(@RequestBody BoardDto boardDto) {
		boardService.update(boardDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
