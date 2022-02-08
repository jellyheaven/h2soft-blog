package com.h2soft.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.h2soft.blog.model.Board;
import com.h2soft.blog.model.User;
import com.h2soft.blog.repository.BoardRepository;

@Service //스프링이 컴포넌트 스캔을 통해서 Bean에 등록해줌. IOC 해줌.
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;	
	
	//글쓰기
	@Transactional
	public void boardWrite(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}

	//전체보기
	@Transactional(readOnly = true)
	public Page<Board> boardAllRead(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	//글상세보기
	public Board boardDetail(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
				});
	}

	//삭제하기
	@Transactional
	public void boardDelete(int id) {		
		boardRepository.deleteById(id);
	}

	//글수정하기 
	@Transactional
	public void boardUpdate(int id, Board reqboard) {
		Board board = boardRepository.findById(id)
						.orElseThrow(()->{
							return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
						});
		board.setTitle(reqboard.getTitle());
		board.setContent(reqboard.getContent());
		//해당 함수로 종료시 (Service 가 종료 될때 ) 트랜잭션이 종료 됩니다. 이때 더티 체킹 자동 업데이트 됨. db.flush
	}
}

