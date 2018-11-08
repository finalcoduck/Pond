package com.coduck.pond.schedule.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.member.vo.MemVo;
import com.coduck.pond.schedule.vo.AttendedVo;


@Repository
public class AttendedDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.attendedMapper.";
	
	public AttendedVo selectTodayAttended (MemVo memVo) {
		return session.selectOne(NAMESPACE+"selectTodayAttended", memVo);
	}
	
	public void insertInAttended (AttendedVo attendedVo) {
		session.insert(NAMESPACE+"insertInAttended",attendedVo);
	}
	
	public void updateOutAttended(AttendedVo attendedVo) {
		session.update(NAMESPACE+"updateOutAttended", attendedVo);
	}
}
