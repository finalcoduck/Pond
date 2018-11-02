package com.coduck.pond.group.service;

import java.util.List;

import com.coduck.pond.group.vo.GroupMemNumDto;
import com.coduck.pond.group.vo.GroupVo;

public interface GroupService {
	
	
	//최초 그룹 생성(등록이미지)
	public void insertGorup (GroupVo groupVo);
	
	//최초 그룹 생성(기본이미지)
	public void insertGorupDefault (GroupVo groupVo);
	
	//group_mem테이블에 저장
	public int insertGroupMem(String inviteCode);
	
	// 회원이 가입한 그룹 목록
	public List<GroupVo> selectGroupList (String memEmail);
	
	//그룹 선택
	public GroupVo selectGroup (int groupNum);
	
	//그룹 삭제
	public void deleteGroup (int groupNum);
	
	//모든 그룹 멤버 숫자 가져오기
	public List<GroupMemNumDto> getGroupMemNum(String memEmail);
}
