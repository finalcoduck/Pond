package com.coduck.pond.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.member.dao.MemberManageDao;
import com.coduck.pond.member.vo.KickHistory;

@Service
public class MemberManageService {
	@Autowired
	private MemberManageDao memberManageDao;
	
	public void kickMemFromGroup(int groupNum, String memEmail) {
		Map<String, String> map = new HashMap<>();
		map.put("groupNum", String.valueOf(groupNum));
		map.put("memEmail", memEmail);
		memberManageDao.kickMemFromGroup(map);
	}
	
	public void kickHistoryInsert(KickHistory kickHistory) {
		memberManageDao.kickHistoryInsert(kickHistory);
	}
	
	public KickHistory checkKickedMem(int groupNum, String memEmail) {
		Map<String, String> map = new HashMap<>();
		map.put("groupNum", String.valueOf(groupNum));
		map.put("memEmail", memEmail);
		return memberManageDao.checkKickedMem(map);
	}
	
	public List<KickHistory> getKickHistory(int groupNum) {
		return memberManageDao.getKickHistory(groupNum);
	}
}
