package com.coduck.pond.board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.board.vo.SubjectVo;

@Repository
public class SubjectDao {
	
	private static final String NAMESPACE = "Mappers.subjectMapper.";
	
	@Autowired
	private SqlSession session;
	
	public List<SubjectVo> selectList (int groupNum){
		return session.selectList(NAMESPACE+"selectList",groupNum);
	}
	
	public SubjectVo selectSubject (int subjectNum){
		return session.selectOne(NAMESPACE+"select",subjectNum);
	}
	
	public void insertSubject(SubjectVo subjectVo) {
		session.insert(NAMESPACE+"insertSubject",subjectVo);
	}
	
	public void deleteSubject(int subjectNum) {
		session.delete(NAMESPACE+"deleteSubject",subjectNum);
	}
}
