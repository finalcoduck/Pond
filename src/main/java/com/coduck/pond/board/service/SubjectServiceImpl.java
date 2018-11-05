package com.coduck.pond.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.board.dao.SubjectDao;
import com.coduck.pond.board.vo.SubjectVo;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	SubjectDao subjectDao;
	
	@Override
	public List<SubjectVo> selectSubjectList(int groupNum) {
		return subjectDao.selectList(groupNum);
	}

	@Override
	public SubjectVo selectSubject(int subjectNum) {
		
		return null;
	}

	@Override
	public void insertSubject(SubjectVo subjectVo) {
		subjectDao.insertSubject(subjectVo);
	}

	@Override
	public void deleteSubject(int subjectNum) {
	
		
	}

}
