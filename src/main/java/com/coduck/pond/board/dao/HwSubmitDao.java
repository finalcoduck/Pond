package com.coduck.pond.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.board.vo.HwSubmitVo;

@Repository
public class HwSubmitDao {
	private static final String NAMESPACE = "Mappers.hwSubmitMapper.";
	
	@Autowired
	private SqlSession session;
	
	public void insertSubmitBoard(HwSubmitVo hwSubmitVo) {
		session.insert(NAMESPACE+"insertHwSubmit", hwSubmitVo);
	}
	
	public int updateHwScore(HwSubmitVo hwSubmitVo) {
		return session.update(NAMESPACE+"updateHwScore", hwSubmitVo);
	}
}
