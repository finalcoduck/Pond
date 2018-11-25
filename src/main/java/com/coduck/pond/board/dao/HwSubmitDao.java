package com.coduck.pond.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.board.vo.HwSubmitDto;
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
	
	public HwSubmitVo detailHwBoard(HwSubmitVo hwSubmitVo) {
		return session.selectOne(NAMESPACE + "detailHw", hwSubmitVo);
	}
	
	public Map<String, List<HwSubmitDto>> getSubmitList(int hwSubmitGroupNum){
		List<HwSubmitDto> studentList = session.selectList(NAMESPACE + "getSubmitList", hwSubmitGroupNum);
		Map<String, List<HwSubmitDto>> map = new HashMap<>();
		map.put("studentList", studentList);
		return map;
	}
	
	public int insertHw(HwSubmitVo hwSubmitVo) {
		return session.insert(NAMESPACE + "insertHw", hwSubmitVo);
	}
	
	public HwSubmitDto detailSubmit(int boardNum) {
		return session.selectOne(NAMESPACE + "detailSubmit", boardNum);
	}
	
}
