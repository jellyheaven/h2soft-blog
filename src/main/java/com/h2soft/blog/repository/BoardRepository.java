package com.h2soft.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2soft.blog.model.Board;

//JPA DAO 
// 자동 빈으로 등록 됨.
//@Repository 생략가능
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
