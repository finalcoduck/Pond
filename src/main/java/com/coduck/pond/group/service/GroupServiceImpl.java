package com.coduck.pond.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.group.dao.GroupDao;
import com.coduck.pond.group.vo.GroupVo;


@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	private GroupDao groupDao;
	
	@Override
	public void insertGorup(GroupVo groupVo) {
		groupDao.insertGroup(groupVo);
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

}
