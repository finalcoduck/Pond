package com.coduck.pond.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.group.vo.GroupVo;

@Repository
public class ProfileDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.ProfileMapper.";
	
	public List<GroupMemVo> getMemberGroupInfo(String email) {
		return session.selectList(NAMESPACE+"getMemberGroupInfo", email);
	}
	
	public GroupVo getGroupInfo(int groupNum){
		return session.selectOne(NAMESPACE+"getGroupInfo", groupNum);
	}
	
	public int updatePhone(Map<String, String> map) {
		return session.update(NAMESPACE+"updatePhone", map);
	}
	
	
	public int updatePwd(Map<String, String> map) {
		return session.update(NAMESPACE+"updatePwd", map);
	}
	
	public void updatePic(Map<String, String> map) {
		session.update(NAMESPACE+"updatePic", map);
	}
}
