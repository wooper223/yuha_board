package com.example.board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
