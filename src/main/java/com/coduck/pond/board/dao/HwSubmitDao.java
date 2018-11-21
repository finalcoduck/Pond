package com.coduck.pond.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return session.update(NAMESPACE + "updateHwScore", hwSubmitVo);
	}
	
	public List<HwSubmitVo> detailHwBoard(int boardNum) {
		return session.selectList(NAMESPACE + "detailHw", boardNum);
	}
	
	public Map<String, List<HwSubmitVo>> getSubmitList(String groupNum){
		List<HwSubmitVo> studentList = session.selectList(NAMESPACE + "getSubmitList", groupNum);
		Map<String, List<HwSubmitVo>> map = new HashMap<>();
		map.put("studentList", studentList);
		return map;
	}
	
}
