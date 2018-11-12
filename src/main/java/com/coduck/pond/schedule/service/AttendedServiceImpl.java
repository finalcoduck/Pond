package com.coduck.pond.schedule.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.core.constant.ErrorCodeConstant;
import com.coduck.pond.member.vo.MemAttendedDto;
import com.coduck.pond.schedule.dao.AttendedDao;
import com.coduck.pond.schedule.vo.AttendedVo;

@Service
public class AttendedServiceImpl implements AttendedService{
	
	@Autowired
	AttendedDao attendedDao;

	@Override
	public boolean isAttended(AttendedVo attendedVo) {
		
		
		AttendedVo attendedResultVo = attendedDao.selectTodayAttended(attendedVo);
		
		//금일 출석한 내용이 없으면 False 있으면 True
		
		if(attendedResultVo == null) {
			return false;
		}else {
			return true;
		}
	
	}

	@Override
	public HashMap<String, Object> attendedIn(AttendedVo attendedVo) {
		HashMap<String,Object> resultMap = new HashMap<String, Object>();
		AttendedVo attendedResultVo = attendedDao.selectTodayAttended(attendedVo);
		
		if(attendedResultVo == null) {
			attendedDao.insertInAttended(attendedVo);
			resultMap.put(ErrorCodeConstant.ERR_C_KEY,ErrorCodeConstant.SUCCESS);
			return resultMap;
		}
		
		resultMap.put(ErrorCodeConstant.ERR_C_KEY,ErrorCodeConstant.FAILURE);
		return resultMap;
	}
}
