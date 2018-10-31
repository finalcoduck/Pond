package com.coduck.pond.group.service;

import java.util.List;

import com.coduck.pond.group.vo.GroupVo;

public interface GroupService {
	
	
	//그룹 생성
	public void insertGorup (GroupVo groupVo);
	
	// 회원이 가입한 그룹 목록
	public List<GroupVo> selectGroupList (String memEmail);
	
	//그룹 선택
	public GroupVo selectGroup (int groupNum);
	
	//그룹 삭제
	public void deleteGroup (int groupNum);
	
}
