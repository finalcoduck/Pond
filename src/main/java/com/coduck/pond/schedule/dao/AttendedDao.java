package com.coduck.pond.schedule.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AttendedDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.attendedMapper.";
	
	
}
