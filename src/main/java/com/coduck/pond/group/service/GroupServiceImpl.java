package com.coduck.pond.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coduck.pond.core.utils.RandomCodeUtility;
import com.coduck.pond.group.dao.GroupDao;
import com.coduck.pond.group.vo.GroupMemNumDto;
import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.schedule.vo.AttendedVo;


@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	private GroupDao groupDao;
	
	@Override
	@Transactional
	public void insertGorup(GroupVo groupVo) {
		String inviteCodeS = RandomCodeUtility.makeRandomCode(); // 랜덤 코드 생성
		String inviteCodeM = RandomCodeUtility.makeRandomCode(); // 랜덤 코드 생성
		groupVo.setInviteCodeS(inviteCodeS);
		groupVo.setInviteCodeM(inviteCodeM);
		groupVo.setInviteCodeStatus('O');
		groupDao.insertGroup(groupVo);
		
		int groupNum = insertGroupMem(inviteCodeS, inviteCodeM);
		
		GroupMemVo groupMemVo = new GroupMemVo(0, groupNum, groupVo.getMemEmail(), 'M');
		groupDao.insertGroupMem(groupMemVo);
	}

	@Override
	public List<GroupVo> selectGroupList(String memEmail) {
		return groupDao.selectGroupList(memEmail);
	}

	@Override
	public GroupVo selectGroup(int groupNum) {
		return groupDao.selectGroup(groupNum);
	}

	@Override
	public void deleteGroup(int groupNum) {
		groupDao.deleteGroup(groupNum);
	}

	@Override
	@Transactional
	public void insertGorupDefault(GroupVo groupVo) {
		String inviteCodeS = RandomCodeUtility.makeRandomCode(); // 랜덤 코드 생성
		String inviteCodeM = RandomCodeUtility.makeRandomCode(); // 랜덤 코드 생성
		groupVo.setInviteCodeS(inviteCodeS);
		groupVo.setInviteCodeM(inviteCodeM);
		groupVo.setInviteCodeStatus('O');
		
		String imgUrl = groupVo.getGroupImage();
		String[] strArr = imgUrl.split("/");
		String groupImage = strArr[strArr.length-1];
		groupVo.setGroupImage(groupImage);
		groupDao.insertGroup(groupVo);
		
		int groupNum = insertGroupMem(inviteCodeS, inviteCodeM);
		
		GroupMemVo groupMemVo = new GroupMemVo(0, groupNum, groupVo.getMemEmail(), 'M');
		groupDao.insertGroupMem(groupMemVo);
	}

	@Override
	public int insertGroupMem(String inviteCodeS, String inviteCodeM) { //여까지
		int groupNum = groupDao.getGroupNum(inviteCodeS, inviteCodeM);
		return groupNum;
	}

	@Override
	public List<GroupMemNumDto> getGroupMemNum(String memEmail) {
		return groupDao.getGroupMemNum(memEmail);
	}

	@Override
	public boolean isQRcodeCorrect(AttendedVo attendedVo) {
		
		GroupVo groupVo = groupDao.selectGroup(attendedVo.getGroupNum());
		if(groupVo.getAttendedQRCode().equals(attendedVo.getAttendedQRCode())) {
			return true;
		}else {
			return false;
		}
		
	}

}
