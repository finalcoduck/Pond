package com.coduck.pond.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coduck.pond.core.utils.RandomCodeUtility;
import com.coduck.pond.group.dao.GroupDao;
import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.group.vo.GroupVo;


@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	private GroupDao groupDao;
	
	@Override
	@Transactional
	public void insertGorup(GroupVo groupVo) {
		String inviteCode = RandomCodeUtility.makeRandomCode(); // 랜덤 코드 생성
		groupVo.setInviteCode(inviteCode);
		groupVo.setInviteCodeStatus('O');
		groupDao.insertGroup(groupVo);
		
		int groupNum = insertGroupMem(inviteCode);
		
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
		String inviteCode = RandomCodeUtility.makeRandomCode(); // 랜덤 코드 생성
		groupVo.setInviteCode(inviteCode);
		groupVo.setInviteCodeStatus('O');
		
		String imgUrl = groupVo.getGroupImage();
		String[] strArr = imgUrl.split("/");
		String groupImage = strArr[strArr.length-1];
		groupVo.setGroupImage(groupImage);
		groupDao.insertGroup(groupVo);
		
		int groupNum = insertGroupMem(inviteCode);
		
		GroupMemVo groupMemVo = new GroupMemVo(0, groupNum, groupVo.getMemEmail(), 'M');
		groupDao.insertGroupMem(groupMemVo);
	}

	@Override
	public int insertGroupMem(String inviteCode) {
		int groupNum = groupDao.getGroupNum(inviteCode);
		return groupNum;
	}

}
