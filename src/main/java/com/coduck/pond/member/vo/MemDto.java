package com.coduck.pond.member.vo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MemDto {
	MemVo memVo;
	Set<Integer> keySet = new HashSet<Integer>();
	Map<Integer, Character> memGroupMap = new HashMap<>();
	
	public MemDto() {
		// TODO Auto-generated constructor stub
	}

	public MemDto(MemVo memVo, Set<Integer> keySet, Map<Integer, Character> memGroupMap) {
		super();
		this.memVo = memVo;
		this.keySet = keySet;
		this.memGroupMap = memGroupMap;
	}

	public MemVo getMemVo() {
		return memVo;
	}

	public void setMemVo(MemVo memVo) {
		this.memVo = memVo;
	}

	public Set<Integer> getKeySet() {
		return keySet;
	}

	public void setKeySet(Set<Integer> keySet) {
		this.keySet = keySet;
	}

	public Map<Integer, Character> getMemGroupMap() {
		return memGroupMap;
	}

	public void setMemGroupMap(Map<Integer, Character> memGroupMap) {
		this.memGroupMap = memGroupMap;
	}

	@Override
	public String toString() {
		return "MemDto [memVo=" + memVo + ", keySet=" + keySet + ", memGroupMap=" + memGroupMap + "]";
	}
	
	
}
