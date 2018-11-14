package com.coduck.pond.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.group.vo.GroupVo;

@Repository
public class InviteDao {
	private static final String NAMESPACE ="Mappers.InviteMapper.";
	@Autowired
	private SqlSession session;
	
	public GroupVo findGroupNumS(String inviteCode) {
		return session.selectOne(NAMESPACE+"findGroupNumS", inviteCode);
	}
	
	public GroupVo findGroupNumM(String inviteCode) {
		return session.selectOne(NAMESPACE+"findGroupNumM", inviteCode);
	}
	
	public void insertGroupMem(GroupMemVo vo) {
		session.insert(NAMESPACE+"insertGroupMem", vo);
	}
}
