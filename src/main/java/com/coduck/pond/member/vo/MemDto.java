package com.coduck.pond.member.vo;

import java.util.HashMap;
import java.util.Map;

public class MemDto {
	MemVo memVo;
	Map<Integer, Character> memGroupMap = new HashMap<>();
	
	public MemDto() {
		// TODO Auto-generated constructor stub
	}

	public MemVo getMemVo() {
		return memVo;
	}

	public void setMemVo(MemVo memVo) {
		this.memVo = memVo;
	}

	public Map<Integer, Character> getMemGroupMap() {
		return memGroupMap;
	}

	public void setMemGroupMap(Map<Integer, Character> memGroupMap) {
		this.memGroupMap = memGroupMap;
	}

	public MemDto(MemVo memVo, Map<Integer, Character> memGroupMap) {
		super();
		this.memVo = memVo;
		this.memGroupMap = memGroupMap;
	}

	@Override
	public String toString() {
		return "MemSessionDto [memVo=" + memVo + ", map=" + memGroupMap + "]";
	}
	
	
}
