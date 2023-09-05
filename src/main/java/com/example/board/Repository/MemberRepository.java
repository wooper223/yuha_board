package com.example.board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.board.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
