package com.coduck.pond.member.dao;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.member.vo.MemAuthVo;
import com.coduck.pond.member.vo.MemVo;
import com.coduck.pond.member.vo.PreMemVo;

@Repository
public class MemberJoinDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.MemberJoinMapper.";
	
	public void insertMember(PreMemVo vo) {
		session.insert(NAMESPACE+"insertMember", vo);
	}
	
	public void insertPreMember(PreMemVo vo) {
		session.insert(NAMESPACE+"insertPreMember", vo);
	}
	
	public void insertAuthKey(MemAuthVo vo) {
		session.insert(NAMESPACE+"insertAuthKey", vo);
	}
	
	public int deletePreMem(MemAuthVo vo) { //인증키,이메일 존재시 pre에서 삭제
		return session.delete(NAMESPACE+"deletePreMem", vo);
	}
	
	public PreMemVo getPreMem(String email) {
		return session.selectOne(NAMESPACE+"getPreMem", email);
	}
	
	public void naverToInsertMember(Map<String, String> map) {
		session.insert(NAMESPACE+"naverToInsertMember", map);
	}
	
	public void deleteAuthKey(String email) {
		session.delete(NAMESPACE+"deleteAuthKey", email);
	}
	
	public MemVo getGoogleMem(String id) {
		return session.selectOne(NAMESPACE+"getGoogleMem", id);
	}
	
	public MemVo checkDupli(String memEmail) {
		return session.selectOne(NAMESPACE+"checkDupli", memEmail);
	}
}
