package com.example.board.Service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.Repository.BoardRepository;
import com.example.board.dto.BoardDto;
import com.example.board.entity.Board;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BoardService {

	private final BoardRepository boardRepository;

	@Transactional
	public Long create(BoardDto boardDto) {
		Board board = new Board(boardDto.getTitle(), boardDto.getContent(), boardDto.getName());
		Board newBoard = boardRepository.save(board);

		return newBoard.getId();
	}

	public BoardDto getOne(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(NoSuchElementException::new);

		return BoardDto.builder()
			.id(board.getId())
			.title(board.getTitle())
			.content(board.getContent())
			.name(board.getName())
			.build();
	}

	@Transactional
	public void update(BoardDto boardDto) {
		Board board = boardRepository.findById(boardDto.getId())
			.orElseThrow(NoSuchElementException::new);

		board.updateBoard(boardDto.getTitle(), boardDto.getContent());
	}

	@Transactional
	public void delete(Long id) {
		boardRepository.deleteById(id);
	}
}
