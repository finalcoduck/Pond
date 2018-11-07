package com.coduck.pond.curriculum.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.curriculum.vo.CurriculumVo;

@Repository
public class CurriculumDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.CurriculumMapper.";
	
	public List<CurriculumVo> getAllCurriculum(int groupNum){
		return session.selectList(NAMESPACE+"getAllCurriculum", groupNum);
	}
	
	public CurriculumVo getOneCurriculum(int crcNum) {
		return session.selectOne(NAMESPACE+"getOneCurriculum", crcNum);
	}
	
	public void updateCurriculum(CurriculumVo vo) {
		session.update(NAMESPACE+"updateCurriculum", vo);
	}
	
	public void deleteCurriculum(int crcNum) {
		session.update(NAMESPACE+"deleteCurriculum", crcNum);
	}
	
	public void insertCurriculum(CurriculumVo vo) {
		session.insert(NAMESPACE+"insertCurriculum", vo);
	}
}
