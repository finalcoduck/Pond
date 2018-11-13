package com.coduck.pond.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.member.vo.KickHistory;

@Repository
public class MemberManageDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.MemberManageMapper.";
	
	public void kickMemFromGroup(Map<String, String> map) {
		session.delete(NAMESPACE+"kickMemFromGroup", map);
	}
	
	public void kickHistoryInsert(KickHistory kickHistory) {
		session.insert(NAMESPACE+"kickHistoryInsert", kickHistory);
	}
	
	public KickHistory checkKickedMem(Map<String, String> map) {
		return session.selectOne(NAMESPACE+"checkKickedMem", map);
	}
	
	public List<KickHistory> getKickHistory(int groupNum) {
		return session.selectList(NAMESPACE+"getKickHistory", groupNum);
	}
}
