package com.coduck.pond.core.utils;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coduck.pond.member.service.ProfileService;
import com.coduck.pond.member.vo.MemDto;
import com.coduck.pond.member.vo.MemVo;

public class GetMemDtoUtility {
	
	// 세션에 저장할 memDto 값들을 구하는 메소드
	public static MemDto getMemDto(MemVo memVo, Map<Integer, Character> memGroupMap) {
		Set<Integer> keySet = memGroupMap.keySet();
		MemDto memDto = new MemDto(memVo, keySet, memGroupMap);
		return memDto;
	}
}


