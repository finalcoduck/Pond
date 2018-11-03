package com.coduck.pond.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.board.vo.BoardSrchDto;
import com.coduck.pond.board.vo.GroupNoticeVo;
import com.coduck.pond.board.vo.HwBoardVo;

@Repository
public class NoticeDao {
	private static final String NAMESPACE = "Mappers.groupNoticeMapper.";
	
	@Autowired
	private SqlSession session;
	
	public List<HwBoardVo> selectNoticeList (BoardSrchDto boardSrchDto){
		return session.selectList(NAMESPACE+"selectNoticeList",boardSrchDto);
	}
	
	public void insertNotice(GroupNoticeVo groupNoticeVo) {
		session.insert(NAMESPACE+"insertNotice",groupNoticeVo);
	}
	
	public void deleteNotice(int ntcNum) {
		session.delete(NAMESPACE+"deleteNotice",ntcNum);
	}
	
}
