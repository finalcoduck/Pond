package com.coduck.pond.member.service;

import java.util.Map;

import com.coduck.pond.member.vo.MemVo;
import com.coduck.pond.member.vo.PreMemVo;

public interface MemberJoinService {
	public void insertPreMember(PreMemVo preMemVo);
	public int insertMember(String authKey, String email);
	public void naverToInsertMember(Map<String, String> map);
	public MemVo checkDupli(String email);
		
}
