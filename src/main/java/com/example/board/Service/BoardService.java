package com.example.board.Service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.board.Repository.BoardRepository;
import com.example.board.dto.BoardDto;
import com.example.board.dto.UserDto;
import com.example.board.entity.Board;
import com.example.board.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BoardService {

	private final BoardRepository boardRepository;

	@Transactional
	public Long createBoard(BoardDto boardDto) {
		User user = new User(boardDto.getUser().getName());
		Board board = new Board(boardDto.getTitle(), boardDto.getContent(), user);
		Board newBoard = boardRepository.save(board);

		return newBoard.getId();
	}

	public BoardDto getBoard(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(NoSuchElementException::new);
		User user = board.getUser();

		UserDto userDto = UserDto.builder()
			.name(user.getName())
			.build();

		return BoardDto.builder()
			.title(board.getTitle())
			.content(board.getContent())
			.user(userDto)
			.build();
	}

	@Transactional
	public void updateBoard(BoardDto boardDto) {
		Board board = boardRepository.findById(boardDto.getId())
			.orElseThrow(NoSuchElementException::new);

		Board updatedBoard = board.updateBoard(board.getTitle(), board.getContent());
		boardRepository.save(updatedBoard);
	}
	@Transactional
	public void deleteBoard(Long id) {
		boardRepository.deleteById(id);
	}
}
