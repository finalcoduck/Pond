package com.coduck.pond.curriculum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.curriculum.dao.CurriculumDao;
import com.coduck.pond.curriculum.vo.CurriculumVo;

@Service
public class CurriculumSerivce {
	@Autowired
	private CurriculumDao curriculumDao;
	
	public List<CurriculumVo> getAllCurriculum(int groupNum){
		return curriculumDao.getAllCurriculum(groupNum);
	}
	
	public CurriculumVo getOneCurriculum(int crcNum) {
		return curriculumDao.getOneCurriculum(crcNum);
	}
	
	public void updateCurriculum(CurriculumVo vo) {
		curriculumDao.updateCurriculum(vo);
	}
	
	public void deleteCurriculum(int crcNum) {
		curriculumDao.deleteCurriculum(crcNum);
	}
	
	public void insertCurriculum(CurriculumVo vo) {
		curriculumDao.insertCurriculum(vo);
	}
}
