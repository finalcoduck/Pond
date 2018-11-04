package com.coduck.pond.board.service;

import java.util.List;
import com.coduck.pond.board.vo.SubjectVo;


public interface SubjectService {
	
	public List<SubjectVo> selectSubjectList (int groupNum);
	
	public SubjectVo selectSubject (int subjectNum);
	
	public void insertSubject(SubjectVo subjectVo);
	
	public void deleteSubject(int subjectNum);
	
}
