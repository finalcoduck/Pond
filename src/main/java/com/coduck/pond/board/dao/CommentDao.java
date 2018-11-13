package com.coduck.pond.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.board.vo.CommentVo;
import com.coduck.pond.board.vo.MemCommentDto;

@Repository
public class CommentDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.CommentMapper.";
	
	public List<CommentVo> getCommentList(String refBoardNum){
		return session.selectList(NAMESPACE+"getCommentList", refBoardNum);
	}
	
	public void insertComment(CommentVo vo){
		session.insert(NAMESPACE+"insertComment", vo);
	}
	
	public void deleteComment(int cmntNum){
		session.delete(NAMESPACE+"deleteComment", cmntNum);
	}
	
	public void updateComment(String cmntContent){
		session.update(NAMESPACE+"updateComment", cmntContent);
	}
	
	public List<MemCommentDto> getMemComment(String refBoardNum){
		return session.selectList(NAMESPACE+"getMemComment", refBoardNum);
	}
}
