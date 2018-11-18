package com.coduck.pond.schedule.dao;


import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coduck.pond.schedule.vo.AttendedVo;
import com.coduck.pond.schedule.vo.MemNameAttendedDto;
import com.coduck.pond.schedule.vo.SrchAttendedDto;


@Repository
public class AttendedDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.attendedMapper.";
	
	public AttendedVo selectTodayAttended (AttendedVo attendedVo) {
		return session.selectOne(NAMESPACE+"selectTodayAttended", attendedVo);
	}
	
	public List<AttendedVo> selectMonthAttended(SrchAttendedDto srchAttendedDto){
		return session.selectList(NAMESPACE+"selectMonthAttended", srchAttendedDto);
	}
	
	public List<MemNameAttendedDto> selectGroupMonthAttended(SrchAttendedDto srchAttendedDto) {
		return session.selectList(NAMESPACE+"selectGroupMonthAttended", srchAttendedDto);
	}
	public void insertInAttended (AttendedVo attendedVo) {
		session.insert(NAMESPACE+"insertInAttended",attendedVo);
	}
	
	public void updateOutAttended(AttendedVo attendedVo) {
		session.update(NAMESPACE+"updateOutAttended", attendedVo);
	}

}
