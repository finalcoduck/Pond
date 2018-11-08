package com.coduck.pond.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.member.dao.InviteDao;

@Service
public class InviteSerivce {
	@Autowired
	private InviteDao inviteDao;
	
	public GroupVo findGroupNum(String inviteCode) {
		return inviteDao.findGroupNum(inviteCode);
	}
	
	public void insertGroupMem(GroupMemVo vo) {
		inviteDao.insertGroupMem(vo);
	}
}
