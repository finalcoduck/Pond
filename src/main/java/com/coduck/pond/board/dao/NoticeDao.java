package com.coduck.pond.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.coduck.pond.board.vo.GroupNoticeVo;

public class NoticeDao {
	private static final String NAMESPACE = "Mappers.groupNoticeMapper.";
	@Autowired
	private SqlSession session;
	
	public void insertNotice(GroupNoticeVo groupNoticeVo) {
		session.insert(NAMESPACE+"insertNotice",groupNoticeVo);
	}
	
	public void deleteNotice(int ntcNum) {
		session.delete(NAMESPACE+"deleteNotice",ntcNum);
	}
	
}
