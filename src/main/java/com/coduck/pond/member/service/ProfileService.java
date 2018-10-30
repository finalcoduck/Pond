package com.coduck.pond.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.member.dao.ProfileDao;

@Service
public class ProfileService {
	@Autowired
	private ProfileDao profileDao;
	
	/*
	 *  회원별 그룹가져와서 MAP에 (그룹번호 , 권한) 으로 넣어서 반환
	 */
	public Map<Integer, Character> getMemberGroupInfo(String email){
		Map<Integer, Character> map = new HashMap<>();
		List<GroupMemVo> list = profileDao.getMemberGroupInfo(email);
		for (GroupMemVo vo : list) {
			map.put(vo.getGroupNum(), vo.getStatus());
		}
		return map;
	}
}
