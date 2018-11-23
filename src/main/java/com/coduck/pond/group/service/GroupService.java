package com.coduck.pond.group.service;

import java.util.List;
import java.util.Map;

import com.coduck.pond.group.vo.GroupMemNumDto;
import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.group.vo.GroupMem_smDto;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.schedule.vo.AttendedVo;

public interface GroupService {
	
	
	//최초 그룹 생성(등록이미지)
	public void insertGorup (GroupVo groupVo);
	
	//최초 그룹 생성(기본이미지)
	public void insertGorupDefault (GroupVo groupVo);
	
	//group_mem테이블에 저장
	int getGroupMem(String inviteCodeS, String inviteCodeM);
	
	// 회원이 가입한 그룹 목록
	public List<GroupVo> selectGroupList (String memEmail);
	
	//그룹 선택
	public GroupVo selectGroup (int groupNum);
	
	//그룹 삭제
	public void deleteGroup (int groupNum);
	
	//모든 그룹 멤버 숫자 가져오기
	public List<GroupMemNumDto> getGroupMemNum(String memEmail);

	//해당 그룹의 멤버 숫자 가져오기
	public GroupMemNumDto getGroupMemCount(int groupNum);
	
	//초대코드 중복확인
	GroupMemVo dupliInviteCode(String memEmail, String groupNum);
	
	//해당그룹의 모든 회원 가져오기
	public Map<String, List<GroupMem_smDto>> getGroupMemList(String groupNum);
	
	//QRcode 일치하는지 조회 
	public boolean isQRcodeCorrect(AttendedVo attendedVo);
	
	//그룹 주소,좌표 넣기
	public void updateGroupAddr(String x, String y, String addr, String groupNum);
	
	//그룹 전화번호 수정
	public void updateGroupPhone(String phone, String groupNum);
	
	//QR코드 업데이트
	public void updateQRcode(GroupVo groupVo);
}
