package com.coduck.pond.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.member.dao.InviteDao;

@Service
public class InviteSerivce {
	@Autowired
	private InviteDao inviteDao;
	
	public Map<String, Object> findGroupNum(String inviteCode) {
		Map<String, Object> map = new HashMap<>();
		GroupVo groupVo = inviteDao.findGroupNumS(inviteCode);
		map.put("groupVo", groupVo);
		map.put("status", 'S');
		if(groupVo == null) {
			groupVo = inviteDao.findGroupNumS(inviteCode);
			map.put("groupVo", groupVo);
			map.put("status", 'M');
		}
		return map;
	}
	
	public void insertGroupMem(GroupMemVo vo) {
		inviteDao.insertGroupMem(vo);
	}
}
