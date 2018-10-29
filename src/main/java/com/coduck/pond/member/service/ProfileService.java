package com.coduck.pond.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.member.dao.ProfileDao;

@Service
public class ProfileService {
	@Autowired
	private ProfileDao profileDao;
	
}
