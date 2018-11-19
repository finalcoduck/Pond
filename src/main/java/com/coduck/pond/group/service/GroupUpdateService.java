package com.coduck.pond.group.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.group.dao.GroupUpdateDao;

@Service
public class GroupUpdateService {
	@Autowired
	private GroupUpdateDao groupUpdateDao;
	
	public void updateGroupColumn(String column, String columnValue, String groupNum) {
		Map<String, String> map = new HashMap<>();
		
		map.put("groupColumnValue", columnValue);
		map.put("groupColumn", column);
		map.put("groupNum", groupNum);
		
		groupUpdateDao.updateGroupColumn(map);
	}
	
	public void updateGroupAddr(String addr,String x, String y, String groupNum) {
		Double longitude = Double.valueOf(x);
		Double latitude = Double.valueOf(y);
		Map<String, Object> map = new HashMap<>();
		map.put("groupAddr", addr);
		map.put("longitude", longitude);
		map.put("latitude", latitude);
		map.put("groupNum", groupNum);
		
		groupUpdateDao.updateGroupAddr(map);
	}
}

