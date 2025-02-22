package com.kh.spring.board.service;

import java.util.ArrayList;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.model.vo.PageInfo;

public interface BoardService {
	
	// * 게시글 목록 조회(+페이징 처리) - R
	int selectListCount(); // 페이징
	ArrayList<Board> selectList(PageInfo pi);
	
	// * 게시글 상세 조회	-R
	int increaseCount(int boardNo);	// 조회수 증가
	Board selectBoard(int boardNo);
	
	// * 게시글 작성	-C
	int insertBoard(Board b);
	
	// * 게시글 수정	-U
	int updateBoard(Board b);
	
	// * 게시글 삭제	-U/D
	int deleteBoard(int boardNo);
	
	// * 댓글 목록 조회	-R	
	ArrayList<Reply> selectReplyList(int boardNo);
	
	// * 댓글 작성 (ajax)		-C
	int insertReply(Reply r);
	
	ArrayList<Board> topListBoard();
	
}
