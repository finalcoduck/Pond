package com.coduck.pond.curriculum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CurriculumDao {
	@Autowired
	private SqlSession session;
}
