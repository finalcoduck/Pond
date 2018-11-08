package com.coduck.pond.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.schedule.dao.AttendedDao;

@Service
public class AttendedServiceImpl implements AttendedService{
	
	@Autowired
	AttendedDao attendedDao;
	
	
	
}
