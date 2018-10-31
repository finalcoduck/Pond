package com.coduck.pond.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.group.vo.GroupVo;
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
	
	/*
	 *  groupNum 으로 내 정보 페이지에 뿌려줄 그룹 정보 받아오기
	 */
	public Map<Integer, GroupVo> getGroupInfo(Set<Integer> keySet){
		Map<Integer, GroupVo> groupInfoMap = new HashMap<>();
		for (Integer i : keySet) {
			GroupVo groupVo = profileDao.getGroupInfo(i);
			groupInfoMap.put(i, groupVo);
		}
		
		return groupInfoMap;
	}
	
	/*
	 *  회원 핸드폰 번호 수정하기
	 */
	public int updatePhone(String phone, String email) {
		Map<String, String> map = new HashMap<>();
		map.put("phone", phone);
		map.put("email", email);
		return profileDao.updatePhone(map);
	}
	
	/*
	 *  회원 비밀번호 수정하기
	 */
	public int updatePwd(String email, String pwd) {
		Map<String, String> map = new HashMap<>();
		map.put("pwd", pwd);
		map.put("email", email);
		return profileDao.updatePwd(map);
	}
	
	/*
	 *  회원 프로필 사전 업데이트
	 */
	public void updatePic(String email, String filename) {
		Map<String, String> map = new HashMap<>();
		map.put("email", email);
		map.put("filename", filename);
		profileDao.updatePic(map);
	}
}

