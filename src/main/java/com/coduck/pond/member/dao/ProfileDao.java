package com.coduck.pond.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.group.vo.GroupMemVo;

@Repository
public class ProfileDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.ProfileMapper";
	
	public List<GroupMemVo> getMemberGroupInfo(String email) {
		return session.selectList(NAMESPACE+"getMemberGroupInfo", email);
	}
}
