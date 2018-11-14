package com.coduck.pond.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.board.dao.CommentDao;
import com.coduck.pond.board.vo.CommentVo;
import com.coduck.pond.board.vo.MemCommentDto;

@Service
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	
	public List<CommentVo> getCommentList(String refBoardNum){
		return commentDao.getCommentList(refBoardNum);
	}
	
	public void insertComment(CommentVo vo){
		commentDao.insertComment(vo);
	}
	
	public void deleteComment(int cmntNum){
		commentDao.deleteComment(cmntNum);
	}
	
	public void updateComment(String cmntContent){
		commentDao.updateComment(cmntContent);
	}
	
	public List<MemCommentDto> getMemComment(String refBoardNum){
		return commentDao.getMemComment(refBoardNum);
	}
}
