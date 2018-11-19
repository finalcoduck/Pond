package com.coduck.pond.group.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupUpdateDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.groupUpdateMapper.";
	
	public void updateGroupColumn(Map<String, String> map) {
		session.update(NAMESPACE+"updateGroupColumn", map);
	}
	
	public void updateGroupAddr(Map<String, Object> map) {
		session.update(NAMESPACE+"updateGroupAddr", map);
	}	
}
