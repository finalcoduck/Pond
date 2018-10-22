package com.coduck.pond.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.member.vo.MemVo;

@Repository
public class MemberLoginDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.MemberLoginMapper.";
	
	public MemVo getOneMem(String email) {
		return session.selectOne(NAMESPACE+"getOneMem", email);
	}
	
	public MemVo getNaverMem(String id) {
		return session.selectOne(NAMESPACE+"getNaverMem", id);
	}
	
	public MemVo checkMem(Map<String, String> map) {
		return session.selectOne(NAMESPACE+"checkMem", map);
	}
	
	public void updatePhone(Map<String, String> map) {
		session.update(NAMESPACE+"updatePhone", map);
	}
	
	public void changeNewPwd(Map<String, String> map) {
		session.update(NAMESPACE+"changeNewPwd", map);
	}
	
	public int authConfirm(Map<String, String> map) {
		return session.selectOne(NAMESPACE+"authConfirm", map);
	}
}
