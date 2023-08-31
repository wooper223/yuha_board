package com.example.board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.board.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
