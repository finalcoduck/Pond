package com.coduck.pond.schedule.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.core.constant.ErrorCodeConstant;
import com.coduck.pond.member.vo.MemAttendedDto;
import com.coduck.pond.schedule.dao.AttendedDao;
import com.coduck.pond.schedule.vo.AttendedVo;
import com.coduck.pond.schedule.vo.SrchAttendedDto;

@Service
public class AttendedServiceImpl implements AttendedService{
	
	@Autowired
	AttendedDao attendedDao;

	@Override
	public boolean isAttended(AttendedVo attendedVo) {
		
		
		AttendedVo attendedResultVo = attendedDao.selectTodayAttended(attendedVo);
		
		//금일 출석한 내용이 없으면 False 있으면 True
		//금일 출석한 내용이 있어도 attendedOut이 null 인 경우 false attendedOut null이 아닌 경우 True 리턴!
		
		if(attendedResultVo != null) {
			if(attendedResultVo.getAttendedOut() == null) {
				return true;
			}
			return false;
		}else {
			return false;
		}
	
	}

	@Override
	public HashMap<String, Object> attendedIn(AttendedVo attendedVo) {
		HashMap<String,Object> resultMap = new HashMap<String, Object>();
		attendedDao.insertInAttended(attendedVo);
		resultMap.put(ErrorCodeConstant.ERR_C_KEY,ErrorCodeConstant.SUCCESS);
		return resultMap;
	}

	@Override
	public List<AttendedVo> selectMonthAttended(SrchAttendedDto srchAttendedDto) {
		
		List<AttendedVo>  AttendedVoList = attendedDao.selectMonthAttended(srchAttendedDto);
		
		return AttendedVoList;
	}

	@Override
	public HashMap<String, Object> attendedOut(AttendedVo attendedVo) {
		HashMap<String,Object> resultMap = new HashMap<String, Object>();
		attendedDao.updateOutAttended(attendedVo);
		resultMap.put(ErrorCodeConstant.ERR_C_KEY,ErrorCodeConstant.SUCCESS);
		return resultMap;
	}
}
